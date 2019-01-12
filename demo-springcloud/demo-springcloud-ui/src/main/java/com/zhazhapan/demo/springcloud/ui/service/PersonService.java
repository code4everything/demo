package com.zhazhapan.demo.springcloud.ui.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pantao
 * @since 2019-01-12
 */
@FeignClient("person")
public interface PersonService {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String save(String name);
}
