package com.spring5vue.springvue.messages.web;

import com.spring5vue.springvue.messages.model.Message;
import com.spring5vue.springvue.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {
    private MessageService messageService;
    @Autowired
    public void setMessageService(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public String index(){
        return "index";
    }
    @GetMapping("/api/messages")
    public ResponseEntity<List<Message>> getMessages(){
        List<Message> messages = messageService.getMessages();
        return ResponseEntity.ok(messages);
    }
    @PostMapping("/api/messages")
    public ResponseEntity<Message> welcome(@RequestBody MessageData messageData){
        Message saved = messageService.save(messageData.getText());
        if(saved == null){
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }
}
