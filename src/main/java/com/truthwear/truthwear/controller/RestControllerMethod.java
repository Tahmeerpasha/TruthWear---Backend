package com.truthwear.truthwear.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestControllerMethod {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }


}
