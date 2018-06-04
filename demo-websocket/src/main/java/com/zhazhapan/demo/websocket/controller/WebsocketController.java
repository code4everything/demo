package com.zhazhapan.demo.websocket.controller;

import com.zhazhapan.demo.websocket.model.RequestMessage;
import com.zhazhapan.demo.websocket.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author pantao
 * @since 2018/6/4
 */
@RestController
public class WebsocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/hello")
    @CrossOrigin(origins = {"*"})
    public ResponseMessage say(HttpServletResponse response, RequestMessage message) {
        System.out.println("say " + message);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return new ResponseMessage("welcome, " + message);
    }
}
