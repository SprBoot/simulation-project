package cn.xuxiaonan.simulationprojectrabbitmq.controller;

import cn.xuxiaonan.simulationprojectrabbitmq.service.ExchangeService;
import cn.xuxiaonan.util.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/exchange")
public class ExchangeController {
    @Autowired
    ExchangeService exchangeService;
    /***
    * @Description: 根据交换机名称创建direct交换机
    * @Param: [directExchangeName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/9
    */
    @ApiOperation(value = "创建direct交换机",notes = "获取url中的direct交换机名称进行创建")
    @ApiImplicitParam(name = "directExchangeName",value = "direct交换机名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "createDirectExchange/{directExchangeName}")
    @ResponseBody
    public Object createDirectExchange(@PathVariable("directExchangeName") String directExchangeName){
        JSONObject jsonObject = null;
        try {
            exchangeService.createDirectExchange(directExchangeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 根据交换机名称创建topic交换机 
    * @Param: [topicExchangeName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "创建topic交换机",notes = "获取url中的topic交换机名称进行创建")
    @ApiImplicitParam(name = "topicExchangeName",value = "topic交换机名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "createTopicExchange/{topicExchangeName}")
    @ResponseBody
    public Object createTopicExchange(@PathVariable("topicExchangeName") String topicExchangeName){
        JSONObject jsonObject = null;
        try {
            exchangeService.createTopicExchange(topicExchangeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /***
    * @Description: 根据交换机名称创建fanout交换机
    * @Param: [fanoutExchangeName]
    * @return: java.lang.Object
    * @Author: dinggc
    * @Date: 2019/6/9
    */
    @ApiOperation(value = "创建fanout交换机",notes = "获取url中的fanout交换机名称进行创建")
    @ApiImplicitParam(name = "fanoutExchangeName",value = "fanout交换机名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "createFanoutExchange/{fanoutExchangeName}")
    @ResponseBody
    public Object createFanoutExchange(@PathVariable("fanoutExchangeName") String fanoutExchangeName){
        JSONObject jsonObject = null;
        try {
            exchangeService.createFanoutExchange(fanoutExchangeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /*** 
    * @Description: 根据交换机名称创建headers交换机 
    * @Param: [headersExchangeName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "创建headers交换机",notes = "获取url中的headers交换机名称进行创建")
    @ApiImplicitParam(name = "headersExchangeName",value = "headers交换机名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "createHeadersExchange/{headersExchangeName}")
    @ResponseBody
    public Object createHeadersExchange(@PathVariable("headersExchangeName") String headersExchangeName){
        JSONObject jsonObject = null;
        try {
            exchangeService.createHeadersExchange(headersExchangeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
    /***
    * @Description: 根据交换机名称删除交换机 
    * @Param: [exchangeName] 
    * @return: java.lang.Object 
    * @Author: dinggc
    * @Date: 2019/6/9 
    */
    @ApiOperation(value = "删除交换机",notes = "获取url中的交换机名称删除交换机")
    @ApiImplicitParam(name = "exchangeName",value = "交换机名称",required = true,dataType = "String",paramType = "path")
    @RequestMapping(value = "deleteExchange/{exchangeName}")
    @ResponseBody
    public Object deleteExchange(@PathVariable("exchangeName") String exchangeName){
        JSONObject jsonObject = null;
        try {
            exchangeService.deleteExchange(exchangeName);
            jsonObject = ResponseUtil.SUCCESS();
        }catch (Exception e){
            jsonObject = ResponseUtil.FAIL();
        }
        return jsonObject;
    }
}
