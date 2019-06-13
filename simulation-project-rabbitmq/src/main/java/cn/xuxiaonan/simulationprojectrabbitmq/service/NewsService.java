/**
 * Copyright (C), 2015-2019
 * FileName: NewsService
 * Author:   A
 * Date:     2019/5/28 13:55
 * Description: 使用feign调用微服务
 */
package cn.xuxiaonan.simulationprojectrabbitmq.service;

import cn.xuxiaonan.simulationprojectrabbitmq.serviceFallbackFactory.NewsClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈使用feign调用微服务〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
@FeignClient(value = "SIMULATION-PROJECT-ZUUL",fallbackFactory = NewsClientFallbackFactory.class)
public interface NewsService {
    /**
     * @Author dinggc
     * @Description //微服务调用
     * @Date 13:58 2019/5/28
     * @Param []
     * @return java.lang.Object
     **/
    @RequestMapping(value = "simulation/user/api/news/getNewsList")
    @ResponseBody
    Object getNewsList();
    /***
     * @Description: 调用es的接口存放新闻信息
     * @Param: []
     * @return: java.lang.Object
     * @Author: dinggc
     * @Date: 2019/6/5
     */
    @RequestMapping(value = "simulation/es/news/save")
    @ResponseBody
    Object save();
}
