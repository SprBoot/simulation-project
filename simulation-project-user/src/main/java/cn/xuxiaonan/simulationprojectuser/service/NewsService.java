/**
 * Copyright (C), 2015-2019
 * FileName: NewsService
 * Author:   A
 * Date:     2019/5/28 12:37
 * Description: 新闻接口
 */
package cn.xuxiaonan.simulationprojectuser.service;

import cn.xuxiaonan.entities.New;

import java.util.List;

/**
 * 〈新闻接口〉
 * @author A
 * @create 2019/5/28
 * @since 1.0.0
 */
public interface NewsService {
    /**
     * @Author dinggc
     * @Description //获取所有新闻
     * @Date 12:38 2019/5/28
     * @Param []
     * @return java.util.List<cn.xuxiaonan.entities.New>
     **/
    List<New> getNewsList();
}
