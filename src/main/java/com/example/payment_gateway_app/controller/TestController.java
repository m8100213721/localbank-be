package com.example.payment_gateway_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/test")
public class TestController {
    @GetMapping
    public String testresponse(){
        String response = "testing successful";
        System.out.println(response);
        return response;
    }
}
