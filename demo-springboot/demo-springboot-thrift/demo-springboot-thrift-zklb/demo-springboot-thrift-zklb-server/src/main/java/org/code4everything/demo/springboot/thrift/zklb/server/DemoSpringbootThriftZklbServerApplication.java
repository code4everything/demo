package org.code4everything.demo.springboot.thrift.zklb.server;

import org.code4everything.demo.springboot.thrift.zklb.server.config.ThriftProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author pantao
 * @since 2019/10/18
 */
@SpringBootApplication
@EnableConfigurationProperties(ThriftProperties.class)
public class DemoSpringbootThriftZklbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootThriftZklbServerApplication.class, args);
    }
}
