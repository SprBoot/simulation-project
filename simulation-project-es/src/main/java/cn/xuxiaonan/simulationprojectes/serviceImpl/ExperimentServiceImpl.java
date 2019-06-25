/**
 * FileName: ExperimentServiceImpl
 * Author:   dinggc
 * Date:     2019/6/25 15:10
 * Description: 实验实现类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.serviceImpl;

import cn.xuxiaonan.simulationprojectes.entities.Experiment;
import cn.xuxiaonan.simulationprojectes.mapper.ExperimentMapper;
import cn.xuxiaonan.simulationprojectes.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验实现类〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
@Service
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    ExperimentMapper experimentMapper;
    @Override
    public List<Experiment> getExperimentList() {
        return experimentMapper.getExperimentList();
    }
}