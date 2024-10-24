package com.spunit.controller;

import com.spunit.model.Message;
import com.spunit.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        chatService.saveMessage(message);
        return message;
    }

    // Optional: Create a method to fetch all messages if needed
    // @GetMapping("/messages")
    // public List<Message> getMessages() {
    //     return chatService.getAllMessages();
    // }
}
