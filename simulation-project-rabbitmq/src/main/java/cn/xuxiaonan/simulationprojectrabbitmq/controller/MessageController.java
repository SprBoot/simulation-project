package cn.xuxiaonan.simulationprojectrabbitmq.controller;

import cn.xuxiaonan.simulationprojectrabbitmq.service.MessageService;
import cn.xuxiaonan.util.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    /***
    * @Description: 通过路由向交换机中推送信息
    * @Param: [message, exchangeName, routeName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/9
    */
    @ApiOperation(value = "通过路由向队列中发送字符串信息",notes = "获取url中的字符串和路由向队列推送信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message",value = "字符串信息",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "routeName",value = "路由名称",required = true,dataType = "String",paramType = "path"),
    })
    @RequestMapping(value = "sendMessageToExchange/{message}/{exchangeName}/{routeName}")
    @ResponseBody
    public Object sendMessageToExchange(@PathVariable("message") String message,@PathVariable("exchangeName") String exchangeName,
                                        @PathVariable("routeName") String routeName){
        JSONObject jsonObject = null;
        try {
            messageService.sendMessageToExchange(message,exchangeName,routeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 根据路由向队列中推送对象信息 
    * @Param: [cls, exchangeName, routeName] 
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "通过路由向队列中发送对象信息",notes = "获取url中的字符串和路由向队列推送对象信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cls",value = "对象信息",required = true,dataType = "Class",paramType = "path"),
            @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "routeName",value = "路由名称",required = true,dataType = "String",paramType = "path"),
    })
    @RequestMapping(value = "sendObject/{cls}/{exchangeName}/{routeName}")
    @ResponseBody
    public Object sendObject(@PathVariable("cls") T cls, @PathVariable("exchangeName") String exchangeName,
                             @PathVariable("routeName") String routeName){
        JSONObject jsonObject = null;
        try {
            messageService.sendObject(cls,exchangeName,routeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 根据队列名称获取队列中的信息 
    * @Param: [queueName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "接受队列中的字符串信息",notes = "获取url中的队列名称获取队列中的字符串信息")
    @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "receive/{queueName}")
    @ResponseBody
    public Object receive(@PathVariable("queueName") String queueName){
        JSONObject jsonObject = null;
        try {
            String msg = messageService.receive(queueName);
            return msg;
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
            return jsonObject;
        }
    }
    /*** 
    * @Description: 根据队列名称获取队列中的对象信息 
    * @Param: [queueName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "接受队列中的对象信息",notes = "获取url中的队列名称获取队列中的对象信息")
    @ApiImplicitParam(name = "queueName",value = "队列名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "receiveObject/{queueName}")
    @ResponseBody
    public Object receiveObject(@PathVariable("queueName") String queueName){
        JSONObject jsonObject = null;
        try {
            T msg = messageService.receiveObject(queueName);
            return msg;
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
            return jsonObject;
        }
    }
    /***
    * @Description: 向延迟队列中推送信息和设置延迟时间
    * @Param: [queueName, queueName, queueName, queueName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/11
    */
    @ApiOperation(value = "推送字符串消息",notes = "向延迟队列中推送信息和设置延迟时间 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message",value = "消息",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "routeName",value = "路由名称",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "time",value = "延迟时间",required = true,dataType = "long",paramType = "path")
    })
    @RequestMapping(value = "sendMessageWithExpiration/{message}/{exchangeName}/{routeName}/{time}")
    @ResponseBody
    public Object sendMessageWithExpiration(@PathVariable("message") String message,@PathVariable("exchangeName") String exchangeName,
                                            @PathVariable("routeName") String routeName,@PathVariable("time") long time){
        JSONObject jsonObject = null;
        try {
            messageService.sendMessageWithExpiration(message,exchangeName,routeName,time);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
}
