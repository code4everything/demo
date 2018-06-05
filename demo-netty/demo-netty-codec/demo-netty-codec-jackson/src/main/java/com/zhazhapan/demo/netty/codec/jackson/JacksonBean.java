package com.zhazhapan.demo.netty.codec.jackson;

import java.util.List;
import java.util.Map;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonBean {

    private int age;

    private String name;

    private List<String> sons;

    private Map<String, String> addresses;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSons() {
        return sons;
    }

    public void setSons(List<String> sons) {
        this.sons = sons;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, String> addresses) {
        this.addresses = addresses;
    }
}
