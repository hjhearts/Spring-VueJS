package com.spring5vue.springvue.messages.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityChecker {
    @Pointcut("@annotation(com.spring5vue.springvue.messages.security.SecurityCheck)")
    public void checkMethodSecurity(){

    }

    @Around("checkMethodSecurity()")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable{
        return joinPoint.proceed();
    }
}
