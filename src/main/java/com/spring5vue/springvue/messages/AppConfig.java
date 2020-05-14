package com.spring5vue.springvue.messages;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppConfig {
    @Bean
    public MessageRepository messageRepository(){
        return new MessageRepository();
    }
    @Bean
    public MessageService messageService(){
        return new MessageService(messageRepository());
    }

    @Bean
    public FilterRegistrationBean<AuditingFilter> auditingFilterFilterRegistrationBean(){
        FilterRegistrationBean<AuditingFilter> registration = new FilterRegistrationBean<>();
        AuditingFilter filter = new AuditingFilter();
        registration.setFilter(filter);
        registration.setOrder(Integer.MAX_VALUE);
        registration.setUrlPatterns(Arrays.asList("/messages/*"));
        return registration;
    }
}
