package com.zhazhapan.demo.springcloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pantao
 * @since 2019-01-12
 */
@Service
public class PersonHystrixService {

    @Autowired
    private PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")
    public String save(String name) {
        return personService.save(name);
    }

    public String fallbackSave() {
        return "调用失败";
    }
}
