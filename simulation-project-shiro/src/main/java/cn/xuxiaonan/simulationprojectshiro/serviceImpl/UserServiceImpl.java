package cn.xuxiaonan.simulationprojectshiro.serviceImpl;

import cn.xuxiaonan.entities.Permission;
import cn.xuxiaonan.entities.User;
import cn.xuxiaonan.simulationprojectshiro.mapper.ShiroMapper;
import cn.xuxiaonan.simulationprojectshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ShiroMapper shiroMapper;
    @Override
    public User getUserInfo(String username) {
        return shiroMapper.getUserInfo(username);
    }

    @Override
    public List<Permission> getPermissionById(String id) {
        return shiroMapper.getPermissionById(id);
    }

    @Override
    public User getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return user;
    }
}
