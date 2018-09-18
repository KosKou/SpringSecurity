package com.security.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class IndexController {


    @GetMapping("/")
    public String showIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "views/loginForm";
    }
}
