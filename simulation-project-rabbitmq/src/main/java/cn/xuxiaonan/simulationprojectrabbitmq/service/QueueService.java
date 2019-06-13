package cn.xuxiaonan.simulationprojectrabbitmq.service;

public interface QueueService {
    /***
     * @Description: 创建队列
     * @Param: [queueName]
     * @return: void
     * @Author: dinggc
     * @Date: 2019/6/6
     */
    void createQueue(String queueName);
    /***
    * @Description: 删除队列 
    * @Param: [queueName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void deleteQueue(String queueName);
    /*** 
    * @Description: 消费队列中的所有消息 
    * @Param: [queueName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void purgeQueue(String queueName);
    /*** 
    * @Description: 设置一个延时队列 
    * @Param: [queueName, deadExchangeName, deadRouteKey] 
    * @return: void
    * @Author: dinggc
    * @Date: 2019/6/11 
    */
    void createDelayQueue(String queueName,String deadExchangeName);
}
