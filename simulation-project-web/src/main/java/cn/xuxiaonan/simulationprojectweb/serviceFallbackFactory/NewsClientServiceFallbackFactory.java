/**
 * Copyright (C), 2015-2019
 * FileName: NewsClientServiceFallbackFactory
 * Author:   A
 * Date:     2019/5/28 13:33
 * Description: 新闻容错
 */
package cn.xuxiaonan.simulationprojectweb.serviceFallbackFactory;

import cn.xuxiaonan.entities.New;
import cn.xuxiaonan.enums.ErrorMessage;
import cn.xuxiaonan.simulationprojectweb.service.NewsService;
import cn.xuxiaonan.util.ResponseUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈新闻容错〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
@Component
public class NewsClientServiceFallbackFactory implements FallbackFactory<NewsService> {
    @Override
    public NewsService create(Throwable throwable) {
        return new NewsService() {
            @Override
            public List<New> getNewsList() {
                New news = new New();
                news.setXwnr("current server is error");
                return ResponseUtil.hystrixError(news);
            }

            @Override
            public Object getInfo(String key) {
                return ResponseUtil.hystrixError(ErrorMessage.SERVERERROR.getMsgInfo());
            }
        };
    }
}
