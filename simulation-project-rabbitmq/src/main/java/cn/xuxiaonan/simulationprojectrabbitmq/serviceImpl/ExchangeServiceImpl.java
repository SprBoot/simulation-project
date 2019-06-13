package cn.xuxiaonan.simulationprojectrabbitmq.serviceImpl;

import cn.xuxiaonan.simulationprojectrabbitmq.service.ExchangeService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    RabbitAdmin rabbitAdmin;
    //创建四种交换机，默认实现持久化，且不进行自动删除
    @Override
    public void createDirectExchange(String directExchangeName) {
        rabbitAdmin.declareExchange(new DirectExchange(directExchangeName,true,false));
    }

    @Override
    public void createTopicExchange(String topicExchangeName) {
        rabbitAdmin.declareExchange(new TopicExchange(topicExchangeName,true,false));
    }

    @Override
    public void createFanoutExchange(String fanoutExchangeName) {
        rabbitAdmin.declareExchange(new FanoutExchange(fanoutExchangeName,true,false));
    }

    @Override
    public void createHeadersExchange(String headersExchangeName) {
        rabbitAdmin.declareExchange(new HeadersExchange(headersExchangeName,true,false));
    }

    @Override
    public void deleteExchange(String exchangeName) {
        rabbitAdmin.deleteExchange(exchangeName);
    }
}
