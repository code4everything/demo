package com.zhazhapan.demo.springboot.security.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2018/7/7
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "welcome to the coding world";
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello spring security";
    }
}
