package cn.xuxiaonan.simulationprojectrabbitmq.service;

public interface BindService {
    /*** 
    * @Description: 通过路由键将队列绑定到交换机 
    * @Param: [queueName, exchangeName, routeName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void bindQueueByRouter(String queueName,String exchangeName,String routeName);
    /*** 
    * @Description: 通过路由对队列进行解绑 
    * @Param: [queueName, exchangeName, routeName]
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void removeBindByRouter(String queueName,String exchangeName,String routeName);
    /*** 
    * @Description: 交换机和交换机通过路由绑定 
    * @Param: [exchangeName, byExchangeName, routeName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void bindExchangeByRouter(String exchangeName,String byExchangeName,String routeName);
}
