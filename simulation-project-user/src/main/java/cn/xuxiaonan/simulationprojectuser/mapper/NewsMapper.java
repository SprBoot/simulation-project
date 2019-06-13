/**
 * Copyright (C), 2015-2019
 * FileName: NewsMapper
 * Author:   A
 * Date:     2019/5/28 12:33
 * Description: 新闻访问dao
 */
package cn.xuxiaonan.simulationprojectuser.mapper;

import cn.xuxiaonan.entities.New;

import java.util.List;

/**
 * 〈新闻访问dao〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
public interface NewsMapper {
    /**
     * @Author dinggc
     * @Description //获取所有的新闻
     * @Date 12:37 2019/5/28
     * @Param []
     * @return java.util.List<cn.xuxiaonan.entities.New>
     **/
    List<New> getNewsList();
}
