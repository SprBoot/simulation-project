package cn.xuxiaonan.simulationprojectes.serviceImpl;

import cn.xuxiaonan.simulationprojectes.entities.New;
import cn.xuxiaonan.simulationprojectes.mapper.NewsMapper;
import cn.xuxiaonan.simulationprojectes.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsServiceImpl implements EsService {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public List<New> getNewsList() {
        return newsMapper.getNewsList();
    }
}
