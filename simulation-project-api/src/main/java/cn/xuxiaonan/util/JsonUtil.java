/**
 * Copyright (C), 2015-2019
 * FileName: JsonUtil
 * Author:   A
 * Date:     2019/5/28 12:45
 * Description: json工具类
 */
package cn.xuxiaonan.util;

import cn.xuxiaonan.util.apiUtil.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.util.Date;
import java.util.List;

/**
 * 〈json工具类〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
public class JsonUtil {
    /**
     * @Author dinggc
     * @Description //将list转换为json数据并自定义数据库中的时间日期格式
     * @Date 12:47 2019/5/28
     * @Param [list]
     * @return net.sf.json.JSONArray
     **/
    public static JSONArray changeListToJson(List<?> list){
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray;
    }
}
