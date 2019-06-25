/**
 * FileName: ExperimentClientFallbackFactory
 * Author:   dinggc
 * Date:     2019/6/25 15:13
 * Description: 实验容错
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.serviceFallbackFactory;

import cn.xuxiaonan.enums.ErrorMessage;
import cn.xuxiaonan.simulationprojectes.entities.Experiment;
import cn.xuxiaonan.simulationprojectes.service.ExperimentService;
import cn.xuxiaonan.util.ResponseUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验容错〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
@Component
public class ExperimentClientFallbackFactory implements FallbackFactory<ExperimentService> {

    @Override
    public ExperimentService create(Throwable throwable) {
        return new ExperimentService() {
            @Override
            public List<Experiment> getExperimentList() {
                return ResponseUtil.hystrixError(ErrorMessage.SERVERERROR.getMsgInfo());
            }
        };
    }
}