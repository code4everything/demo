package com.zhazhapan.demo.springcloud.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author pantao
 * @since 2019-01-12
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class DemoSpringcloudMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringcloudMonitorApplication.class, args);
    }
}

