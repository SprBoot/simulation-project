package cn.xuxiaonan.simulationprojectrabbitmq.serviceImpl;

import cn.xuxiaonan.simulationprojectrabbitmq.service.QueueService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    RabbitAdmin rabbitAdmin;
    @Override
    public void createQueue(String queueName) {
        //创建队列并设置为持久化
        rabbitAdmin.declareQueue(new Queue(queueName,true));
    }

    @Override
    public void deleteQueue(String queueName) {
        rabbitAdmin.deleteQueue(queueName);
    }

    @Override
    public void purgeQueue(String queueName) {
        rabbitAdmin.purgeQueue(queueName,false);
    }

    @Override
    public void createDelayQueue(String queueName, String deadExchangeName) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("x-dead-letter-exchange", deadExchangeName);
        rabbitAdmin.declareQueue(new Queue(queueName,true,false,false,map));
    }
}
