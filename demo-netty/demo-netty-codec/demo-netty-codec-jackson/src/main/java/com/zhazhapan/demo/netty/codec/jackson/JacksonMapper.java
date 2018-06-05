package com.zhazhapan.demo.netty.codec.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhazhapan.util.Checker;

/**
 * @author pantao
 * @since 2018/6/5
 */
public class JacksonMapper {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getInstance() {
        if (Checker.isNull(objectMapper)) {
            synchronized (JacksonMapper.class) {
                if (Checker.isNull(objectMapper)) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }
}
