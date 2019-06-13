package cn.xuxiaonan.simulationprojectshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@MapperScan(value = "cn.xuxiaonan.simulationprojectshiro.mapper")
public class SimulationProjectShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectShiroApplication.class, args);
    }

}
