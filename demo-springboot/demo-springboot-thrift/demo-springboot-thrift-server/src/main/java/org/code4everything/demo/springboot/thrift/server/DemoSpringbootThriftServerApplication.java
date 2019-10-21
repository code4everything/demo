package org.code4everything.demo.springboot.thrift.server;

import org.code4everything.demo.springboot.thrift.server.config.ThriftProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author pantao
 * @since 2019/1016
 */
@SpringBootApplication
@EnableConfigurationProperties(ThriftProperties.class)
public class DemoSpringbootThriftServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootThriftServerApplication.class, args);
    }
}
