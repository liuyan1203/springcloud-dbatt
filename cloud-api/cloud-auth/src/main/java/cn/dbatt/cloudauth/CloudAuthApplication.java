package cn.dbatt.cloudauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
//声明该服务为Eureka中的服务消费方
@EnableDiscoveryClient
//开启Feign声明式服务通信
@EnableFeignClients
@EnableHystrixDashboard
@SpringBootApplication
public class CloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAuthApplication.class, args);
    }

}
