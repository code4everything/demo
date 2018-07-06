package com.zhazhapan.demo.springboot.redis.entity;

import java.io.Serializable;

/**
 * @author pantao
 * @since 2018/7/6
 */
public class User implements Serializable {

    private static final long serialVersionUID = -2058425002981184332L;

    private String username;

    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
