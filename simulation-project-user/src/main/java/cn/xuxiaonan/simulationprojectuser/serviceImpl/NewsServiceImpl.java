/**
 * Copyright (C), 2015-2019
 * FileName: NewsServiceImpl
 * Author:   A
 * Date:     2019/5/28 12:39
 * Description: 新闻实现类
 */
package cn.xuxiaonan.simulationprojectuser.serviceImpl;

import cn.xuxiaonan.entities.New;
import cn.xuxiaonan.simulationprojectuser.mapper.NewsMapper;
import cn.xuxiaonan.simulationprojectuser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈新闻实现类〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public List<New> getNewsList() {
        return newsMapper.getNewsList();
    }
}
