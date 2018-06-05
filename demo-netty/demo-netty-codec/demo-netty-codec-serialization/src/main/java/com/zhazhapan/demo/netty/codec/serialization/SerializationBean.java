package com.zhazhapan.demo.netty.codec.serialization;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class SerializationBean implements Serializable {

    private String name;

    private int age;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
