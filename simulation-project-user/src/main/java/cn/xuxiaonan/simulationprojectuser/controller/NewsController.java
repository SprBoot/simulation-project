/**
 * Copyright (C), 2015-2019
 * FileName: NewsController
 * Author:   A
 * Date:     2019/5/28 12:40
 * Description: 新闻的暴露接口类
 */
package cn.xuxiaonan.simulationprojectuser.controller;

import cn.xuxiaonan.entities.New;
import cn.xuxiaonan.simulationprojectuser.service.NewsService;
import cn.xuxiaonan.simulationprojectuser.service.UserService;
import cn.xuxiaonan.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈新闻的暴露接口类〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/api")
@Slf4j
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    /**
     * @Author dinggc
     * @Description //新闻数据接口
     * @Date 12:50 2019/5/2
     * @Param []
     * @return java.lang.Object
     **/
    @RequestMapping(value = "news/getNewsList")
    @ResponseBody
    public Object getNewsList(){
        List<New> newsList = newsService.getNewsList();
        log.info("get all news");
        return JsonUtil.changeListToJson(newsList);
    }
    /***
    * @Description: 获取redis共享的session
    * @Param: [request]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/5/31
    */
    @RequestMapping(value = "getSessionId")
    @ResponseBody
    public Object getSessionId(HttpServletRequest request){
        return userService.getCurrentUser();
    }
}
