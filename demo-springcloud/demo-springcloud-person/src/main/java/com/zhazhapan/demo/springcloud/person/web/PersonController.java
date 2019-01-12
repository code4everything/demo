package com.zhazhapan.demo.springcloud.person.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2019-01-12
 */
@RestController
public class PersonController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam String name) {
        return name;
    }
}
