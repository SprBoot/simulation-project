/**
 * FileName: ExperimentEsController
 * Author:   dinggc
 * Date:     2019/6/25 15:17
 * Description: es的实验controller类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.controller;

import cn.xuxiaonan.enums.EsConstant;
import cn.xuxiaonan.enums.Keywords;
import cn.xuxiaonan.simulationprojectes.Repository.ExperimentRepository;
import cn.xuxiaonan.simulationprojectes.entities.Experiment;
import cn.xuxiaonan.simulationprojectes.service.ExperimentService;
import cn.xuxiaonan.simulationprojectes.util.QueryUtils;
import cn.xuxiaonan.util.ResponseUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈es的实验controller类〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/experiment")
@Slf4j
public class ExperimentEsController {
    @Autowired
    ExperimentRepository experimentRepository;
    @Autowired
    ExperimentService experimentService;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    /**
     * 功能描述: <br>
     * 〈向es数据库中存入所有的实验信息〉
     *
     * @param
     * @return:void
     * @since: 1.0.0
     * @Author:dinggc
     * @Date: 2019/6/25 15:22
     */
    @RequestMapping(value = "saveExperiment")
    @ResponseBody
    @ApiOperation(value = "存放所有的实验信息",notes = "向es中存放实验信息")
    public Object saveExperiment(){
        log.info("添加所有的实验信息！");
        JSONObject jsonObject = null;
        try {
            List<Experiment> experimentList = experimentService.getExperimentList();
            experimentRepository.saveAll(experimentList);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            e.printStackTrace();
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*
     * @Author dinggc
     * @Description //根据关键字查询相关的实验
     * @Date 16:11 2019/6/25
     * @Param [keywords]
     * @return java.lang.Object
     **/
    @ApiOperation(value = "根据关键字进行分页查询返回高亮",notes = "获取url中的关键字")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keywords",value = "关键字",required = true,dataType = "Object",paramType = "path"),
            @ApiImplicitParam(name = "pageNumber",value = "当前页",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "pageSize",value = "关键字",required = true,dataType = "Integer",paramType = "path")
    })
    @GetMapping(value = "searchMatchQuery/{keywords}/{pageNumber}/{pageSize}")
    @ResponseBody
    public Object searchMatchQuery(@PathVariable("keywords") Object keywords,@PathVariable("pageNumber") Integer pageNumber,
                                   @PathVariable("pageSize") Integer pageSize){
        log.info("根据关键字"+keywords+"查询对应的实验信息");
        JSONObject jsonObject = null;
        try {
            List<String> highLightFields = new ArrayList<String>();
            highLightFields.add("name");
            highLightFields.add("coverId");
            highLightFields.add("context");
            NativeSearchQueryBuilder queryBuilder = QueryUtils.getQueryBuilderWithPageAndHighLight(Keywords.EXPERIMENTNAME.getKeywordsName(), keywords, highLightFields,
                    pageNumber, pageSize);
            Page<Experiment> page = null;
            page = elasticsearchTemplate.queryForPage(queryBuilder.build(), Experiment.class, new SearchResultMapper() {
                @Override
                public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                    //获取高亮搜索数据
                    List<Experiment> experimentList = new ArrayList<Experiment>();
                    SearchHits hits = searchResponse.getHits();
                    for(SearchHit searchHit : hits){
                        if(hits.getHits().length<=0){
                            return null;
                        }
                        Experiment experiment = new Experiment();
                        //公共字段
                        experiment.setId(String.valueOf(searchHit.getId()));
                        experiment.setName(String.valueOf(searchHit.getSourceAsMap().get("name")));
                        experiment.setCoverId(String.valueOf(searchHit.getSourceAsMap().get("coverId")));
                        experiment.setContext(String.valueOf(searchHit.getSourceAsMap().get("context")));
                        experiment.setDate(new Date(Long.valueOf(searchHit.getSourceAsMap().get("date").toString())));

                        //反射调用set方法将高亮内容设置进去
                        try {
                            for(String field : highLightFields){
                                HighlightField highlightField = searchHit.getHighlightFields().get(field);
                                if(highlightField != null){
                                    String setMethodName = QueryUtils.parSetName(field);
                                    Class<? extends Experiment> clazz = experiment.getClass();
                                    Method setMethod = clazz.getMethod(setMethodName,String.class);

                                    String highlightStr = highlightField.fragments()[0].toString();
                                    //截取字符串
                                    if("name".equals(field) && highlightStr.length()>50){
                                        highlightStr = EsConstant.STARTTAG.getTagName() + highlightStr + EsConstant.ENDTAG.getTagName();
                                    }
                                    setMethod.invoke(experiment,highlightStr);
                                }
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        experimentList.add(experiment);
                    }
                    if(experimentList.size()>0){
                        AggregatedPage<T> result = new AggregatedPageImpl<T>((List<T>) experimentList,pageable,searchResponse.getHits()
                        .getTotalHits());
                        return result;
                    }
                    return null;
                }
            });
            List<Experiment> experimentList = Lists.newArrayList(page.getContent());
            return experimentList;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject = ResponseUtil.FAIL();
            return jsonObject;
        }
    }
}