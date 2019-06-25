/**
 * FileName: ExperimentService
 * Author:   dinggc
 * Date:     2019/6/25 15:08
 * Description: 实验接口
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.service;

import cn.xuxiaonan.simulationprojectes.entities.Experiment;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验接口〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
public interface ExperimentService{
    /**
     * 功能描述: <br>
     * 〈返回查询到的所有的实验信息〉
     *
     * @param null
     * @return:List<Experiment>
     * @since: 1.0.0
     * @Author:dinggc
     * @Date: 2019/6/25 15:08
     */
    List<Experiment> getExperimentList();
}