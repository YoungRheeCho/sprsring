package com.example.sprbasic2025summer.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
spring container가 구동할 때 controller로 인식
controller에도 주소가 필요..?
*/
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/javareview1")
    public Map<String, Object> javareview1(){
        //변수 선언
        int a = 0;
        double b = 0.0;
        boolean c = false;
        String stringA = "";

        //조건문
        if(a > 10){
            c = true;
        }

        if(c){
            stringA = "abc";
        }

        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                System.out.println(i + " X " + j + " = " + i*j);
            }
        }

        String[] array_a = {"a", "b", "c"};
        for(String str : array_a){
            System.out.println(str);
        }

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(list.get(2));
        return null;
    }
    
}
