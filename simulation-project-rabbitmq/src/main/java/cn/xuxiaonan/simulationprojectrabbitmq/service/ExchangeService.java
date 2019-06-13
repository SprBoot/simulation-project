package cn.xuxiaonan.simulationprojectrabbitmq.service;

public interface ExchangeService {
    /*** 
    * @Description: 创建direct交换机
    * @Param: [directExchangeName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void createDirectExchange(String directExchangeName);
    /*** 
    * @Description: 创建topic交换机 
    * @Param: [topicExchangeName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void createTopicExchange(String topicExchangeName);
    /***
    * @Description: 创建fanout交换机
    * @Param: [fanoutExchangeName]
    * @return: void
    * @Author: dinggc
    * @Date: 2019/6/6
    */
    void createFanoutExchange(String fanoutExchangeName);
    /*** 
    * @Description: 创建headers交换机 
    * @Param: [headersExchangeName]
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void createHeadersExchange(String headersExchangeName);
    /*** 
    * @Description: 删除交换机 
    * @Param: [exchangeName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void deleteExchange(String exchangeName);
}
