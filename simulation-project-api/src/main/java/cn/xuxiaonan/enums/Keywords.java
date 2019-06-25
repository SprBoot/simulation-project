package cn.xuxiaonan.enums;

public enum Keywords {
    TITLE("title"),
    EXPERIMENTNAME("name");
    private String keywordsName;
    /**
     * @Author dinggc
     * @Description //单参构造函数
     * @Date 10:35 2019/5/28
     * @Param [symbolName]
     * @return
     **/
    Keywords(String keywordsName) {
        this.keywordsName = keywordsName;
    }
    /**
     * @Author dinggc
     * @Description //获取当前的关键字
     * @Date 10:35 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getKeywordsName() {
        return keywordsName;
    }
    /**
     * @Author dinggc
     * @Description //无参构造函数
     * @Date 10:36 2019/5/28
     * @Param []
     * @return
     **/
    Keywords() {
    }
}
