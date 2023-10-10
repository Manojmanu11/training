package com.example.Websocket.controller;

import com.example.Websocket.model.Greeting;
import com.example.Websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings ")
    public Greeting greet(Message message) throws InterruptedException {
        return new Greeting("Hello Mr/Ms, " +
                HtmlUtils.htmlEscape(message.getName()  ));
    }
}
