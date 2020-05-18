package com.spring5vue.springvue.messages.service;

import com.spring5vue.springvue.messages.security.SecurityCheck;
import com.spring5vue.springvue.messages.model.Message;
import com.spring5vue.springvue.messages.repository.MessageRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MessageService {
    private MessageRepository messageRepository;
    private final static Log logger = LogFactory.getLog(MessageService.class);
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    @SecurityCheck
    @Transactional(noRollbackFor = UnsupportedOperationException.class)
    public Message save(String text){
        Message message =  messageRepository.saveMessage(new Message(text));
        updateStatistics();
        return message;
    }

    public void updateStatistics(){
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Transactional(readOnly = true)
    public List<Message> getMessages() {
        return messageRepository.getMessages();
    }
}
