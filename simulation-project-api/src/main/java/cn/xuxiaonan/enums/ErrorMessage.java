/**
 * Copyright (C), 2015-2019
 * FileName: ErrorMessage
 * Author:   A
 * Date:     2019/5/28 20:55
 * Description: 错误信息
 */
package cn.xuxiaonan.enums;

/**
 * 〈错误信息〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
public enum  ErrorMessage {
    SERVERERROR("current server is error"),
    NULLMESSAGE("current info is null");
    private String msgInfo;
    /**
     * @Author dinggc
     * @Description //构造函数
     * @Date 20:56 2019/5/28
     * @Param [msgInfo]
     * @return
     **/
    ErrorMessage(String msgInfo){
        this.msgInfo = msgInfo;
    }
    /**
     * @Author dinggc
     * @Description //获取提示的错误信息
     * @Date 20:56 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getMsgInfo() {
        return msgInfo;
    }
}
