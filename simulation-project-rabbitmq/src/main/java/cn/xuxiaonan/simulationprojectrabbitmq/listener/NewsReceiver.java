package cn.xuxiaonan.simulationprojectrabbitmq.listener;

import cn.xuxiaonan.simulationprojectrabbitmq.service.RabbitService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
* @Description: 订阅模式的监听
* @Author: dinggc
* @Date: 2019/6/5
*/
@Component
@RabbitListener(queues = "direct.consume")
public class NewsReceiver {
    @Autowired
    RabbitService rabbitService;
    @RabbitHandler
    public void receiver(String msg){
        System.out.println(msg);
    }
}
