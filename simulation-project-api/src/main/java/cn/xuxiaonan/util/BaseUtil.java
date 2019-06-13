package cn.xuxiaonan.util;

import org.springframework.util.StringUtils;

/***
* @Description 基础工具类
* @Author: dinggc
* @Date: 2019/5/30
*/
public class BaseUtil {
    /***
    * @Description: 判断当前信息是否为空 
    * @Param: [value] 
    * @return: boolean 
    * @Author: dinggc
    * @Date: 2019/5/30 
    */
    public static boolean isNull(Object value){
        boolean flag = true;
        if(StringUtils.isEmpty(value)){
            flag = false;
        }
        return flag;
    }
}
