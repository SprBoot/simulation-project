package cn.xuxiaonan.simulationprojectuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(value = "cn.xuxiaonan.simulationprojectuser.mapper")
@EnableEurekaClient
@EnableFeignClients
public class SimulationProjectUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectUserApplication.class, args);
    }

}
