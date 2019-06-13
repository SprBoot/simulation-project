package cn.xuxiaonan.simulationprojectzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableZuulProxy
@EnableEurekaClient
public class SimulationProjectZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationProjectZuulApplication.class, args);
    }

}
