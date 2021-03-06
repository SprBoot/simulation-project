package cn.xuxiaonan.simulationprojectrabbitmq.serviceFallbackFactory;

import cn.xuxiaonan.enums.ErrorMessage;
import cn.xuxiaonan.simulationprojectrabbitmq.service.NewsService;
import cn.xuxiaonan.util.ResponseUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class NewsClientFallbackFactory implements FallbackFactory<NewsService> {
    @Override
    public NewsService create(Throwable throwable) {
        return new NewsService() {
            @Override
            public Object getNewsList() {
                return  ResponseUtil.hystrixError(ErrorMessage.SERVERERROR.getMsgInfo());
            }

            @Override
            public Object save() {
                return ResponseUtil.hystrixError(ErrorMessage.SERVERERROR.getMsgInfo());
            }
        };
    }
}
