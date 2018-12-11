package com.zhazhapan.demo.springboot.shiro;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pantao
 * @since 2018-12-09
 */
@SpringBootApplication
@EnableSwagger2Doc
public class DemoSpringbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootShiroApplication.class, args);
    }
}
