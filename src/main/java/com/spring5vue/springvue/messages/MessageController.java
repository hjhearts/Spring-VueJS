package com.spring5vue.springvue.messages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messages")
public class MessageController {
    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("message", "Hello Welcome to SpringBoot!");
        return "welcome";
    }
}