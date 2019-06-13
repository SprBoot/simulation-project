package cn.xuxiaonan.simulationprojectshiro.service;

import cn.xuxiaonan.entities.Permission;
import cn.xuxiaonan.entities.User;

import java.util.List;

public interface UserService {
    /*** 
    * @Description: 根据用户名获取用户信息 
    * @Param: [username] 
    * @return: cn.xuxiaonan.entities.User
    * @Author: dinggc
    * @Date: 2019/6/4 
    */
    User getUserInfo(String username);
    /***
     * @Description: 根据id获取用户的权限信息
     * @Param: [id]
     * @return: java.util.List<cn.xuxiaonan.entities.Permission>
     * @Author: dinggc
     * @Date: 2019/6/4
     */
    List<Permission> getPermissionById(String id);
    /***
    * @Description: 获取当前对象 
    * @Param: [] 
    * @return: cn.xuxiaonan.entities.User 
    * @Author: dinggc
    * @Date: 2019/6/4 
    */
    User getCurrentUser();
}
