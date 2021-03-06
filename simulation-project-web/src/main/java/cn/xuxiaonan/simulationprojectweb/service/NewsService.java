/**
 * Copyright (C), 2015-2019
 * FileName: NewsService
 * Author:   A
 * Date:     2019/5/28 13:55
 * Description: 使用feign调用微服务
 */
package cn.xuxiaonan.simulationprojectweb.service;

import cn.xuxiaonan.simulationprojectweb.serviceFallbackFactory.NewsClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈使用feign调用微服务〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
@FeignClient(value = "SIMULATION-PROJECT-ZUUL",fallbackFactory = NewsClientServiceFallbackFactory.class)
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
    * @Description: 获取session信息 
    * @Param: [request, key] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/5/30 
    */
    @RequestMapping(value = "simulation/user-session/session/getInfo")
    @ResponseBody
    Object getInfo(@RequestParam String key);
}
