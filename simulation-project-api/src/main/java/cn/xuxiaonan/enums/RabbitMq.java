package cn.xuxiaonan.enums;

public enum RabbitMq {
    FANOUTNEWS("fanout.News"),
    FANOUTEXCHANGE("fanoutExchange");
    private String name;
    /**
     * @Author dinggc
     * @Description //构造函数
     * @Date 20:56 2019/5/28
     * @Param [msgInfo]
     * @return
     **/
    RabbitMq(String name){
        this.name = name;
    }
    /**
     * @Author dinggc
     * @Description //获取信息
     * @Date 20:56 2019/5/28
     * @Param []
     * @return java.lang.String
     **/
    public String getName() {
        return name;
    }
}
