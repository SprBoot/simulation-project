/**
 * FileName: ExperimentRepository
 * Author:   dinggc
 * Date:     2019/6/25 15:11
 * Description: 实验api
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.Repository;

import cn.xuxiaonan.simulationprojectes.entities.Experiment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验api〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
@Component
public interface ExperimentRepository extends ElasticsearchRepository<Experiment,String> {

}