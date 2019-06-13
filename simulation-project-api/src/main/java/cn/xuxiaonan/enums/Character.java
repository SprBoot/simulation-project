/**
 * Copyright (C), 2015-2019
 * FileName: symbol
 * Author:   A
 * Date:     2019/5/28 10:34
 * Description: 符号
 */
package cn.xuxiaonan.enums;

/**
 * 〈符号〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
public enum Character {
    SUBTRACT("-"),
    NULLCHARACTER(""),
    DOT(".");
    private String symbolName;
    /**
     * @Author dinggc
     * @Description //单参构造函数
     * @Date 10:35 2019/5/28
     * @Param [symbolName]
     * @return
     **/
    Character(String symbolName) {
        this.symbolName = symbolName;
    }
    /**
     * @Author dinggc
     * @Description //获取当前的符号
     * @Date 10:35 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getSymbolName() {
        return symbolName;
    }
    /**
     * @Author dinggc
     * @Description //无参构造函数
     * @Date 10:36 2019/5/28
     * @Param []
     * @return
     **/
    Character() {
    }
}


