package com.spring5vue.springvue.messages;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageService {
    private MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    public void save(String text){
        this.messageRepository.saveMessage(new Message(text));
    }
}
