package cn.xuxiaonan.simulationprojectrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
public class SimulationProjectRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectRabbitmqApplication.class, args);
    }

}
