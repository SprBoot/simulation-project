package cn.xuxiaonan.simulationprojectshiro.controller;

import cn.xuxiaonan.simulationprojectshiro.service.UserService;
import cn.xuxiaonan.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    /***
    * @Description: 获取当前对象
    * @Param: []
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/4
    */
    @RequestMapping(value = "getCurrentUser")
    @ResponseBody
    public Object getCurrentUser(){
        try {
            return userService.getCurrentUser();
        }catch (Exception e){
            return ResponseUtil.FAIL();
        }
    }
    /*** 
    * @Description: 如果未登陆，默认跳转的链接 
    * @Param: [] 
    * @return: net.sf.json.JSONObject 
    * @Author: dinggc
    * @Date: 2019/6/4 
    */
    @RequestMapping(value = "signIn")
    @ResponseBody
    public Object signIn(HttpServletRequest request){
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin",true);
        HttpSession session = null;
        try {
            SecurityUtils.getSubject().login(token);
            session = request.getSession();
            session.setAttribute("user",getCurrentUser());
        }catch (Exception e){
            return "error";
        }
        return session.getId();
    }
    /*** 
    * @Description: 权限认证失败默认跳转到的链接 
    * @Param: [] 
    * @return: net.sf.json.JSONObject 
    * @Author: dinggc
    * @Date: 2019/6/4 
    */
    @RequestMapping(value = "authorization")
    @ResponseBody
    public JSONObject authorization(){
        return ResponseUtil.FAIL();
    }
    /***
    * @Description: 默认拦截的链接
    * @Param: []
    * @return: java.lang.String
    * @Author: dinggc
    * @Date: 2019/6/4
    */
    @RequestMapping(value = "login")
    @ResponseBody
    public String login(){
        return "login";
    }
}
