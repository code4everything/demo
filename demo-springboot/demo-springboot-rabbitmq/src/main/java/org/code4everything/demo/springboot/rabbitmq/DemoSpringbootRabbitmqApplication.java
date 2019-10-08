package org.code4everything.demo.springboot.rabbitmq;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author pantao
 * @since 2019/10/08
 */
@EnableScheduling
@EnableSwagger2Doc
@SpringBootApplication
public class DemoSpringbootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootRabbitmqApplication.class, args);
    }
}
