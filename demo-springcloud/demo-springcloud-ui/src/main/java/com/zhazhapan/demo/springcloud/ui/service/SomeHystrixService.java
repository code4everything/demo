package com.zhazhapan.demo.springcloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author pantao
 * @since 2019-01-12
 */
@Service
public class SomeHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String get() {
        return restTemplate.getForObject("http://some/get", String.class);
    }

    public String fallbackSome() {
        return "调用失败";
    }
}
