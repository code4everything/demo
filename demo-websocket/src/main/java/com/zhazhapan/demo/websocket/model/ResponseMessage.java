package com.zhazhapan.demo.websocket.model;

/**
 * @author pantao
 * @since 2018/6/4
 */
public class ResponseMessage {

    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
