package cn.xuxiaonan.simulationprojectshiro.realm;

import cn.xuxiaonan.entities.Permission;
import cn.xuxiaonan.entities.User;
import cn.xuxiaonan.simulationprojectshiro.serviceImpl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    /***
     * @author dinggc
     * Description //授权用户权限
     * Date 上午8:43 19-1-2
     * Param [principalCollection]
     * return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份信息(在上边的doGetAuthecticationInfo认证通过填充到SimpleAuthenticationInfo)
        User user = (User) principalCollection.getPrimaryPrincipal();
        //根据信息获取权限信息
        //连接数据库。。。
        //模拟从数据库获取到数据
        List<Permission> permissions = null;
        try {
            permissions = userService.getPermissionById(user.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //...
        List<String> permission = new ArrayList<String>();
        for(Permission syspermission:permissions) {
            permission.add(syspermission.getPermission());
        }
        //查询到权限数据，返回
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /***
     * @author dinggc
     * Description //验证用户身份
     * Date 上午8:43 19-1-2
     * Param [authenticationToken]
     * return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = null;
        try {
            user = userService.getUserInfo(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(user==null){
            return null;
        }
        String PIN = user.getPassword();
        return new SimpleAuthenticationInfo(user,PIN,getName());
    }
}
