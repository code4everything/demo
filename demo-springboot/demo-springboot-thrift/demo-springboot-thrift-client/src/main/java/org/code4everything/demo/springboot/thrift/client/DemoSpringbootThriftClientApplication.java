package org.code4everything.demo.springboot.thrift.client;

import org.code4everything.demo.springboot.thrift.client.config.ThriftProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author pantao
 * @since 2019/1016
 */
@SpringBootApplication
@EnableConfigurationProperties(ThriftProperties.class)
public class DemoSpringbootThriftClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootThriftClientApplication.class, args);
    }
}
