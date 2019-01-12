package com.zhazhapan.demo.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author pantao
 * @since 2019-01-09
 */
@SpringBootApplication
@EnableEurekaServer
public class DemoSpringcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringcloudEurekaApplication.class, args);
    }
}

