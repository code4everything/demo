package com.zhazhapan.demo.websocket.controller;

import com.zhazhapan.demo.websocket.model.RequestMessage;
import com.zhazhapan.demo.websocket.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2018/6/4
 */
@RestController
public class WebsocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/hello")
    public ResponseMessage say(RequestMessage message) {
        System.out.println("say " + message.getMessage());
        return new ResponseMessage("welcome, " + message.getMessage());
    }
}
