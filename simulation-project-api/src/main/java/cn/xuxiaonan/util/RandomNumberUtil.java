/**
 * Copyright (C), 2015-2019
 * FileName: RandomNumberUtil
 * Author:   A
 * Date:     2019/5/28 10:31
 * Description: 随机数生成工具类
 */
package cn.xuxiaonan.util;

import cn.xuxiaonan.enums.Character;

import java.util.UUID;

/**
 * 〈随机数生成工具类〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
public class RandomNumberUtil {
    /**
     * @Author dinggc
     * @Description //返回随机的UUID
     * @Date 10:41 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace(Character.SUBTRACT.getSymbolName(),Character.NULLCHARACTER.getSymbolName());
        return uuidStr;
    }
}
