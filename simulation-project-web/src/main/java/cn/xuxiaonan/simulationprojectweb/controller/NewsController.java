/**
 * Copyright (C), 2015-2019
 * FileName: NewsController
 * Author:   A
 * Date:     2019/5/28 13:59
 * Description: 消费端调用服务
 */
package cn.xuxiaonan.simulationprojectweb.controller;

import cn.xuxiaonan.simulationprojectweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈消费端调用服务〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsService newsService;
    /**
     * @Author dinggc
     * @Description //获取所有的新闻
     * @Date 14:01 2019/5/28
     * @Param []
     * @return java.lang.Object
     **/
    @RequestMapping(value = "getNews")
    @ResponseBody
    public Object getNews(){
        return newsService.getNewsList();
    }

    @RequestMapping(value = "getSession")
    @ResponseBody
    public Object getSession(){
        return newsService.getInfo("username");
    }
}
