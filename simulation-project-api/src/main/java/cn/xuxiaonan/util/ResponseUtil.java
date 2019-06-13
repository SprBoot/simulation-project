package cn.xuxiaonan.util;

import cn.xuxiaonan.enums.ReturnCode;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: api
 * @description: 返回的json信息
 * @author: dinggc
 * @create: 2019-02-20 13:58
 **/
public class ResponseUtil {
    static JSONObject jsonObject = new JSONObject();
    /**
     * @Description: 返回成功信息
     * @Param:
     * @return:
     * @Author: dinggc
     * @Date: 2019/1/29
     */
    public static JSONObject SUCCESS(){
        jsonObject.put("isSuccess",true);
        jsonObject.put("code", ReturnCode.SUCCESS.getCode());
        jsonObject.put("msg",ReturnCode.SUCCESS.getMsg());
        jsonObject.put("date",TimeUtil.getCurrentTime());
        return jsonObject;
    }
    /**
     * @Description: 返回失败信息
     * @Param:
     * @return:
     * @Author: dinggc
     * @Date: 2019/1/29
     */
    public static JSONObject FAIL(){
        jsonObject.put("isSuccess",false);
        jsonObject.put("code",ReturnCode.FAIL.getCode());
        jsonObject.put("msg",ReturnCode.FAIL.getMsg());
        jsonObject.put("date",TimeUtil.getCurrentTime());
        return jsonObject;
    }
    /**
     * @Author dinggc
     * @Description //若服务器出错，以List返回时封装错误信息
     * @Date 20:54 2019/5/28
     * @Param [value]
     * @return java.util.List<org.apache.poi.ss.formula.functions.T>
     **/
    public static <T> List hystrixError(T value){
        List<T> list = new ArrayList<>();
        list.add(value);
        return list;
    }
    /*** 
    * @Description: 判断当前返回对象是否是字符串类型 
    * @Param: [obj] 
    * @return: boolean 
    * @Author: dinggc
    * @Date: 2019/6/4 
    */
    public static boolean IfStringClass(Object obj){
        return obj instanceof String;
    }
}
