package cn.xuxiaonan.simulationprojectrabbitmq.serviceImpl;

import cn.xuxiaonan.simulationprojectrabbitmq.service.BindService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BindServiceImpl implements BindService {
    @Autowired
    RabbitAdmin rabbitAdmin;
    @Override
    public void bindQueueByRouter(String queueName, String exchangeName, String routeName) {
        rabbitAdmin.declareBinding(new Binding(queueName,Binding.DestinationType.QUEUE,
                exchangeName,routeName,new HashMap<>()));
    }

    @Override
    public void removeBindByRouter(String queueName, String exchangeName, String routeName) {
        rabbitAdmin.removeBinding(BindingBuilder.bind(new Queue(queueName)).to(new TopicExchange(exchangeName)).with(routeName));
    }

    @Override
    public void bindExchangeByRouter(String exchangeName, String byExchangeName, String routeName) {
        rabbitAdmin.declareBinding(new Binding(exchangeName,Binding.DestinationType.EXCHANGE,byExchangeName,routeName,
                new HashMap<>()));
    }
}
