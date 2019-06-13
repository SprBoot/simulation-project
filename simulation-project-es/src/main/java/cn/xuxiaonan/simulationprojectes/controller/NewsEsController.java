package cn.xuxiaonan.simulationprojectes.controller;

import cn.xuxiaonan.enums.Keywords;
import cn.xuxiaonan.simulationprojectes.Repository.NewsRepository;
import cn.xuxiaonan.simulationprojectes.entities.New;
import cn.xuxiaonan.simulationprojectes.service.EsService;
import cn.xuxiaonan.simulationprojectes.service.NewsService;
import cn.xuxiaonan.util.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/news")
public class NewsEsController {
    @Autowired
    NewsService newsService;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    EsService esService;
    /***
    *  （1）统计某个字段的数量
     *     ValueCountBuilder vcb=  AggregationBuilders.count("count_uid").field("uid");
     * （2）去重统计某个字段的数量（有少量误差）
     *     CardinalityBuilder cb= AggregationBuilders.cardinality("distinct_count_uid").field("uid");
     * （3）聚合过滤
     *     FilterAggregationBuilder fab= AggregationBuilders.filter("uid_filter").filter(QueryBuilders.queryStringQuery("uid:001"));
     * （4）按某个字段分组
     *     TermsBuilder tb=  AggregationBuilders.terms("group_name").field("name");
     * （5）求和
     *     SumBuilder  sumBuilder=	AggregationBuilders.sum("sum_price").field("price");
     * （6）求平均
     *     AvgBuilder ab= AggregationBuilders.avg("avg_price").field("price");
     * （7）求最大值
     *     MaxBuilder mb= AggregationBuilders.max("max_price").field("price");
     * （8）求最小值
     *     MinBuilder min=	AggregationBuilders.min("min_price").field("price");
     * （9）按日期间隔分组
     *     DateHistogramBuilder dhb= AggregationBuilders.dateHistogram("dh").field("date");
     * （10）获取聚合里面的结果
     *     TopHitsBuilder thb=  AggregationBuilders.topHits("top_result");
     * （11）嵌套的聚合
     *     NestedBuilder nb= AggregationBuilders.nested("negsted_path").path("quests");
     * （12）反转嵌套
     * AggregationBuilders.reverseNested("res_negsted").path("kps ");
    */
    /***
    * @Description: es存放所有的新闻信息
    * @Param: []
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/5
    */
    @RequestMapping(value = "save")
    @ResponseBody
    public Object save(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<New> newsList = esService.getNewsList();
            newsRepository.saveAll(newsList);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            e.printStackTrace();
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 根据关键字进行查找 
    * @Param: [keywords]
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/12 
    */
    @ApiOperation(value = "根据关键字进行查询",notes = "获取url中的关键字")
    @ApiImplicitParam(name = "keywords",value = "关键字",required = true,dataType = "Object",paramType = "path")
    @RequestMapping(value = "searchMatchQuery/{keywords}")
    @ResponseBody
    public Object searchMatchQuery(@PathVariable("keywords") Object keywords){
        //构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery(Keywords.TITLE.getKeywordsName(),keywords));
        //查询
        Page<New> news = newsRepository.search(queryBuilder.build());
        return news;
    }

    /***
     * @Description: 根据关键字进行分页查找
     * @Param: [keywords]
     * @return: java.lang.Object
     * @Author: dinggc
     * @Date: 2019/6/12
     */
    @ApiOperation(value = "根据关键字进行分页查询",notes = "获取url中的关键字")
    @ApiImplicitParam(name = "keywords",value = "关键字",required = true,dataType = "Object",paramType = "path")
    @RequestMapping(value = "searchMatchQueryByPage/{keywords}")
    @ResponseBody
    public Object searchMatchQueryByPage(@PathVariable("keywords") Object keywords){
        //构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery(Keywords.TITLE.getKeywordsName(),keywords));
        //分页
        int page = 0;
        int size = 10;
        queryBuilder.withPageable(PageRequest.of(page,size));
        //查询
        Page<New> news = newsRepository.search(queryBuilder.build());
        return news;
    }
}
