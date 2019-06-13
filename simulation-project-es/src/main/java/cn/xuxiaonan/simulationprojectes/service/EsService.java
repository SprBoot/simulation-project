package cn.xuxiaonan.simulationprojectes.service;

import cn.xuxiaonan.simulationprojectes.entities.New;

import java.util.List;

public interface EsService {
    /*** 
    * @Description: 获取所有的新闻 
    * @Param: [] 
    * @return: java.util.List<cn.xuxiaonan.simulationprojectes.entities.New> 
    * @Author: dinggc
    * @Date: 2019/6/6 
    */
    List<New> getNewsList();
}
