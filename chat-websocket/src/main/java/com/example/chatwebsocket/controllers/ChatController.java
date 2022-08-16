package com.example.chatwebsocket.controllers;

import com.example.chatwebsocket.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/chat")
    public Message message( Message message) throws Exception {
        return new Message( message.getUsername(), message.getUsername());
    }
}
