package cn.xuxiaonan.simulationprojectrabbitmq.service;

import org.apache.poi.ss.formula.functions.T;

public interface MessageService {
    /*** 
    * @Description: 发送信息到交换机，以字符串的形式发送 
    * @Param: [message] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void sendMessageToExchange(String message,String exchangeName,String routeName);
    /*** 
    * @Description: 发送对用的对象到交换机 
    * @Param: [cls, exchangeName, routeName] 
    * @return: void 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    void sendObject(T cls,String exchangeName,String routeName);
    /*** 
    * @Description: 从队列中获取消息 
    * @Param: [queueName] 
    * @return: org.springframework.amqp.core.Message 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    String receive(String queueName);
    /*** 
    * @Description: 获取队列中的对象信息 
    * @Param: [queueName] 
    * @return: org.apache.poi.ss.formula.functions.T 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    T receiveObject(String queueName);
    /***
    * @Description: 推送信息并设置延迟时间
    * @Param: [message, exchangeName, expiration]
    * @return: void
    * @Author: dinggc
    * @Date: 2019/6/11
    */
    void sendMessageWithExpiration(String message,String exchangeName,String routeName,long expiration);
}
