package cn.xuxiaonan.simulationprojectshiro.config;

import cn.xuxiaonan.simulationprojectshiro.realm.ShiroRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/***
 * @author dinggc
 * Description //Shiro的配置文件
 * Date 下午5:02 18-12-31
 * Param
 * return
 **/
@Configuration
public class ShiroConfig {
    /**
     * @author dinggc
     * Description //ShiroFilterFactoryBean 处理拦截资源文件问题
     *      * 注意：单独一个ShiroFilterFactoryBean配置是会报错的，因为在初始化ShiroFilterFactoryBean
     *      * 的时候需要注入：SecurityManager
     *      *
     *      * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔
     *      * 2、设置多个过滤器时，全部验证通过才为通过
     *      * 3、部分过滤器可指定参数
     * Date 下午5:02 18-12-31
     * Param [securityManager]
     * return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     **/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        //必须设置SecurityManager
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //如果不设置默认会自动寻找web工程目录下的login.jsp页面
        shiroFilterFactoryBean.setLoginUrl("/user/signIn");
        // 登录成功后要跳转的链接
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/authorization");

        //自定义拦截器
        Map<String, Filter> filterMap = new LinkedHashMap<String,Filter>();
        //限制同一账号同时在线的个数
        //filterMap.put("kickout",kickoutSessionControlFilter);
        shiroFilterFactoryBean.setFilters(filterMap);

        // 权限控制map.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/user/login","authc");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        // 从数据库获取动态的权限
        // filterChainDefinitionMap.put("/add", "perms[权限添加]");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //logout这个拦截器是shiro已经实现好了的。
        // 从数据库获取
        /*List<SysPermissionInit> list = sysPermissionInitService.selectAll();
        for (SysPermissionInit sysPermissionInit : list) {
            filterChainDefinitionMap.put(sysPermissionInit.getUrl(),
                    sysPermissionInit.getPermissionInit());
        }*/

        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    /***
     * @author dinggc
     * Description //引入realm配置类
     * Date 下午5:03 18-12-31
     * Param []
     * return org.apache.shiro.mgt.SecurityManager
     **/
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm());
        // 自定义缓存实现 使用redis
        //securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        //securityManager.setSessionManager(sessionManager());
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public ShiroRealm myShiroRealm(){
        return new ShiroRealm();
    }

    /***
     * @author dinggc
     * Description //Cookie对象
     * Date 下午5:04 18-12-31
     * Param []
     * return org.apache.shiro.web.servlet.SimpleCookie
     **/
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

    /***
     * @author dinggc
     * Description //实现记住我的功能
     * Date 下午5:04 18-12-31
     * Param []
     * return org.apache.shiro.web.mgt.CookieRememberMeManager
     **/
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
    /***
     * @author dinggc
     * Description //使用Shiro注解
     * Date 下午5:04 18-12-31
     * Param [securityManager]
     * return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     **/
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
                = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    /***
     * @author dinggc
     * Description //使用AOP的代理
     * Date 下午5:05 18-12-31
     * Param []
     * return org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
     **/
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
}