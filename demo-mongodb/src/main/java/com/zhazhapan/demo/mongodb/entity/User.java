package com.zhazhapan.demo.mongodb.entity;

import java.util.Date;

/**
 * @author pantao
 * @since 2018/6/4
 */
public class User {

    private String name;

    private String gender;

    private Date birth;

    public User() {}

    public User(String name, String gender, Date birth) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
