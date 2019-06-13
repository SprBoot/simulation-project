package cn.xuxiaonan.simulationprojectrabbitmq.controller;

import cn.xuxiaonan.simulationprojectrabbitmq.service.QueueService;
import cn.xuxiaonan.util.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/queue")
public class QueueController {
    @Autowired
    QueueService queueService;
    /***
    * @Description: 创建队列的接口
    * @Param: [queueName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/6
    */
    @ApiOperation(value = "创建队列",notes = "获取url中的队列名称进行队列的创建")
    @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "createQueue/{queueName}",method = RequestMethod.GET)
    @ResponseBody
    public Object createQueue(@PathVariable(value = "queueName") String queueName){
        JSONObject jsonObject = null;
        try {
            queueService.createQueue(queueName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /***
    * @Description: 根据队列名称删除队列
    * @Param: [queueName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/6
    */
    @ApiOperation(value = "删除队列",notes = "获取url中的队列名称进行队列的删除")
    @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "deleteQueue/{queueName}")
    @ResponseBody
    public Object deleteQueue(@PathVariable(value = "queueName") String queueName){
        JSONObject jsonObject = null;
        try {
            queueService.deleteQueue(queueName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 根据队列名称消费队列中的信息 
    * @Param: [queueName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "消费队列",notes = "获取url中的队列名称进行队列信息的消费")
    @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "purgeQueue/{queueName}")
    @ResponseBody
    public Object purgeQueue(@PathVariable(value = "queueName") String queueName){
        JSONObject jsonObject = null;
        try {
            queueService.purgeQueue(queueName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 创建延迟队列 
    * @Param: [queueName, deadExchangeName, deadRouteKey, time] 
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/11 
    */
    @ApiOperation(value = "创建延迟队列",notes = "获取url中的信息创建延迟队列")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "deadExchangeName",value = "死信交换机名称",required = true,dataType = "String",paramType = "path")
    })
    @RequestMapping(value = "createDelayQueue/{queueName}/{deadExchangeName}")
    @ResponseBody
    public Object createDelayQueue(@PathVariable(value = "queueName") String queueName,@PathVariable(value = "deadExchangeName") String deadExchangeName){
        JSONObject jsonObject = null;
        try {
            queueService.createDelayQueue(queueName,deadExchangeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
}
