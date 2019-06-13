package cn.xuxiaonan.simulationprojectrabbitmq.controller;

import cn.xuxiaonan.simulationprojectrabbitmq.service.BindService;
import cn.xuxiaonan.util.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/bind")
public class BindController {
    @Autowired
    BindService bindService;
    /*** 
    * @Description: 通过路由将队列绑定到交换机上
    * @Param: [queueName, exchangeName, routeName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "通过路由绑定队列到交换机",notes = "获取url中的队列名称，交换机名称和路由进行绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "routeName",value = "路由名称",required = true,dataType = "String",paramType = "path"),
    })
    @RequestMapping(value = "bindQueueByRouter/{queueName}/{exchangeName}/{routeName}")
    @ResponseBody
    public Object bindQueueByRouter(@PathVariable("queueName") String queueName,@PathVariable("exchangeName") String exchangeName,
                                    @PathVariable("routeName") String routeName){
        JSONObject jsonObject = null;
        try {
            bindService.bindQueueByRouter(queueName,exchangeName,routeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /***
    * @Description: 通过路由解绑队列
    * @Param: [queueName, exchangeName, routeName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/9
    */
    @ApiOperation(value = "通过路由删除绑定规则",notes = "获取url中的队列名称，交换机名称和路由进行解绑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "routeName",value = "路由名称",required = true,dataType = "String",paramType = "path"),
    })
    @RequestMapping(value = "removeBindByRouter/{queueName}/{exchangeName}/{routeName}")
    @ResponseBody
    public Object removeBindByRouter(@PathVariable("queueName") String queueName,@PathVariable("exchangeName") String exchangeName,
                                     @PathVariable("routeName") String routeName){
        JSONObject jsonObject = null;
        try {
            bindService.removeBindByRouter(queueName,exchangeName,routeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 通过路由进行交换机和交换机的绑定 
    * @Param: [exchangeName, byExchangeName, routeName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9
    */
    @ApiOperation(value = "通过路由进行交换机和交换机的绑定",notes = "获取url中的交换机名称和路由进行交换机的绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "byExchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "routeName",value = "路由名称",required = true,dataType = "String",paramType = "path"),
    })
    @RequestMapping(value = "bindExchangeByRouter/{exchangeName}/{byExchangeName}/{routeName}")
    @ResponseBody
    public Object bindExchangeByRouter(@PathVariable("exchangeName") String exchangeName,@PathVariable("byExchangeName") String byExchangeName,
                                       @PathVariable("routeName") String routeName){
        JSONObject jsonObject = null;
        try {
            bindService.bindExchangeByRouter(exchangeName,byExchangeName,routeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
}
