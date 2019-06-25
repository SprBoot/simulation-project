/**
 * FileName: QueryUtils
 * Author:   dinggc
 * Date:     2019/6/25 16:03
 * Description: 查询工具类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.util;

import cn.xuxiaonan.enums.EsConstant;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈查询工具类〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
public class QueryUtils {
    /*
     * @Author dinggc
     * @Description //构建查询器
     * @Date 16:09 2019/6/25
     * @Param [field, keywords]
     * @return org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
     **/
    public static NativeSearchQueryBuilder getQueryBuilder(String field,Object keywords){
        //构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery(field,keywords));
        return queryBuilder;
    }
    /*
     * @Author dinggc
     * @Description //根据关键字进行查询返回高亮并分页
     * @Date 16:57 2019/6/25
     * @Param [field, keywords]
     * @return org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
     **/
    public static NativeSearchQueryBuilder getQueryBuilderWithPageAndHighLight(String field, Object keywords, List<String> highLightFields,
                                                                               Integer pageNumber, Integer pageSize){

        // 页码
        if (pageNumber == null || pageNumber < 0) {
            pageNumber = 0;
        }
        // 页数
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        //构建查询
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery(field,keywords));
        //高亮设置
        Field[] fields = new Field[highLightFields.size()];
        for(int x=0;x<highLightFields.size();x++){
            fields[x] = new HighlightBuilder.Field(highLightFields.get(x)).preTags(EsConstant.STARTTAG.getTagName())
                    .postTags(EsConstant.ENDTAG.getTagName());
        }
        queryBuilder.withHighlightFields(fields);
        //分页设置
        queryBuilder.withPageable(PageRequest.of(pageNumber,pageSize));
        return queryBuilder;
    }
    /*
     * @Author dinggc
     * @Description //反射机制
     * @Date 17:55 2019/6/25
     * @Param [fieldName]
     * @return java.lang.String
     **/
    public static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "set" + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }
}