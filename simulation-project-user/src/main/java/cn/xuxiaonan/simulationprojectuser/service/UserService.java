package cn.xuxiaonan.simulationprojectuser.service;

import cn.xuxiaonan.simulationprojectuser.serviceFallbackFactory.UserClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "SIMULATION-PROJECT-ZUUL",fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserService {
    /**
     * @Author dinggc
     * @Description //微服务调用
     * @Date 13:58 2019/5/28
     * @Param []
     * @return java.lang.Object
     **/
    @RequestMapping(value = "simulation/shiro/user/getCurrentUser")
    @ResponseBody
    Object getCurrentUser();
}
