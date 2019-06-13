package cn.xuxiaonan.simulationprojectuser.serviceFallbackFactory;

import cn.xuxiaonan.enums.ErrorMessage;
import cn.xuxiaonan.simulationprojectuser.service.UserService;
import cn.xuxiaonan.util.ResponseUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public Object getCurrentUser() {
                return  ResponseUtil.hystrixError(ErrorMessage.SERVERERROR.getMsgInfo());
            }
        };
    }
}
