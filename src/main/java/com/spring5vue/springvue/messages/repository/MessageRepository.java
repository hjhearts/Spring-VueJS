package com.spring5vue.springvue.messages.repository;

import com.spring5vue.springvue.messages.model.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageRepository {
    private final static Log log = LogFactory.getLog(MessageRepository.class);

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public Message saveMessage(Message message){
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
        return message;
    }

    public List<Message> getMessages() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Message";
        Query<Message> query = session.createQuery(hql, Message.class);
        return query.list();
    }
}