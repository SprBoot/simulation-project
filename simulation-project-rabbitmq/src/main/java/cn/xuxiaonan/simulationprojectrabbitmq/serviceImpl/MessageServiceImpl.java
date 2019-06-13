package cn.xuxiaonan.simulationprojectrabbitmq.serviceImpl;

import cn.xuxiaonan.simulationprojectrabbitmq.service.MessageService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void sendMessageToExchange(String message,String exchangeName,String routeName) {
        Message msg = new Message(message.getBytes(),new MessageProperties());
        rabbitTemplate.send(exchangeName,routeName,msg);
    }

    @Override
    public void sendObject(T cls, String exchangeName, String routeName) {
        rabbitTemplate.convertAndSend(exchangeName,routeName,cls);
    }
    @Override
    public String receive(String queueName) {
        Message msg = rabbitTemplate.receive(queueName,20001);
        String info = msg.toString();
        return info;
    }

    @Override
    public T receiveObject(String queueName) {
        Object convert = rabbitTemplate.receiveAndConvert(queueName, 20001);
        return (T) convert;
    }

    @Override
    public void sendMessageWithExpiration(String message, String exchangeName,String routeName,long expiration) {
        MessagePostProcessor msg = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message msg) throws AmqpException {
                // 设置延迟毫秒值
                msg.getMessageProperties().setExpiration(String.valueOf(expiration));
                return msg;
            }
        };
        rabbitTemplate.convertAndSend(exchangeName,routeName,message,msg);
    }
}
