package com.zhazhapan.demo.springboot.mongodb.entity;

import org.springframework.data.annotation.Id;

/**
 * @author pantao
 * @since 2018/7/6
 */
public class User {

    @Id
    private Long id;

    private String username;

    private Integer age;

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
