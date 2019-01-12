package com.zhazhapan.demo.springcloud.some;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2019-01-12
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DemoSpringcloudSomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringcloudSomeApplication.class, args);
    }

    @RequestMapping("/get")
    public String get() {
        return "hello!";
    }
}

