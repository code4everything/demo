package com.zhazhapan.demo.springboot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author pantao
 * @since 2018/7/5
 */
@Configuration
public class ActivemqConfig {

    @Bean(name = "counting")
    public Queue counting(){
        return new ActiveMQQueue("demo.counting");
    }

    @Bean(name = "newRiskMessage")
    public Queue newRiskMessage(){
    return new ActiveMQQueue("demo.new.risk.message");
    }
}
