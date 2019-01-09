package com.zhazhapan.demo.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author pantao
 * @since 2019-01-09
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class DemoSpringcloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringcloudConfigApplication.class, args);
    }
}

