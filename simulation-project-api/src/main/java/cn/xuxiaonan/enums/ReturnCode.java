package cn.xuxiaonan.enums;
/** 
* @Description: 返回的代码枚举类 
* @Param:  
* @return:  
* @Author: dinggc
* @Date: 2019/2/20 
*/ 
public enum ReturnCode {
    SUCCESS("200","成功"),
    FAIL("404","失败");

    private String code;
    private String msg;
    /**
     * @Author dinggc
     * @Description //代码
     * @Date 11:06 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getCode() {
        return code;
    }
    /**
     * @Author dinggc
     * @Description //消息提示
     * @Date 11:06 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getMsg() {
        return msg;
    }
    /**
     * @Author dinggc
     * @Description //构造函数
     * @Date 11:06 2019/5/28
     * @Param [code, msg]
     * @return
     **/
    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
