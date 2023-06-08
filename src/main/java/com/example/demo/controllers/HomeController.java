package com.example.demo.controllers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class HomeController {
    @GetMapping("/hello")
    public String hello(){
        return new JSONObject().accumulate("message","Hello WOrld").toString();
    }
}
