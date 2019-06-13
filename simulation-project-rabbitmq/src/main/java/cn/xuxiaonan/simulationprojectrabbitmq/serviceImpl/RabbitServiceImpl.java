package cn.xuxiaonan.simulationprojectrabbitmq.serviceImpl;

import cn.xuxiaonan.simulationprojectrabbitmq.service.NewsService;
import cn.xuxiaonan.simulationprojectrabbitmq.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitServiceImpl implements RabbitService{
    @Autowired
    NewsService newsService;
    @Override
    public void saveNews() {
        newsService.save();
    }

}
