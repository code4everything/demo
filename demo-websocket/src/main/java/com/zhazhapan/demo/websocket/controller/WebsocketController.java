package com.zhazhapan.demo.websocket.controller;

import com.zhazhapan.demo.websocket.model.RequestMessage;
import com.zhazhapan.demo.websocket.model.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pantao
 * @since 2018/6/4
 */
@RestController
public class WebsocketController {

    final SimpMessageSendingOperations operations;

    @Autowired
    public WebsocketController(SimpMessageSendingOperations operations) {this.operations = operations;}

    @MessageMapping("/welcome")
    @SendTo("/topic/hello")
    public ResponseMessage say(RequestMessage message) {
        System.out.println("say " + message.getMessage());
        return new ResponseMessage("welcome, " + message.getMessage());
    }

    /**
     * 点对点发送
     */
    @Scheduled(fixedDelay = 1000)
    public void broadcast() {
        operations.convertAndSendToUser("test", "hello", "{\"message\":\"server broadcast\"}");
    }
}
