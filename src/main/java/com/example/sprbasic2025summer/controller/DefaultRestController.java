package com.example.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class DefaultRestController {
    @RequestMapping("/calculate")
    public Map<String,Object> calculate(int a, int b){
        Map<String,Object> map = new HashMap<>();
        map.put("sum",a + b);
        return map;
    }

    @RequestMapping("/multiply")
    public Map<String,Object> multiply(int a, int b){
        Map<String,Object> map = new HashMap<>();
        map.put("result",a*b);
        return map;
    }
}
