package com.dailtcodebuffer.springboottutorialaziz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value(value = "${welcome.message}")
    private String message;
    @GetMapping("/get")
    public String helloWorld (){
        return message;
    }

}
