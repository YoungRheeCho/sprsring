package com.example.sprbasic2025summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultPageController {

    @RequestMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }
    /*
    @RequestMapping("/")
    public String index2(){
        return "index";
    }
    @RequestMapping("/index")
    public String index3(){
        return "index";
    }*/

    @RequestMapping("/aaa")
    public String aaa(@RequestParam String name, @RequestParam String phone, Model model){
        System.out.println("name : " + name);
        System.out.println("phone : " + phone);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        return "aaa";
    }

    @RequestMapping("/calculate")
    public String calculate(String num1, String num2, Model model){
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        int int_num1 = Integer.parseInt(num1);
        int int_num2 = Integer.parseInt(num2);
        int sum = int_num1 + int_num2;

        model.addAttribute("sum", sum);
        return "calculate";
    }

    @RequestMapping("/calculate2")
    public String calculate2(int num1, int num2, Model model){
        int sum = num1 * num2;
        model.addAttribute("sum", sum);
        /*
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("sum", sum);
        temp.put("code", "success");
        model.addAttribute("result", temp);
        */
        return "calculate";
    }

    @RequestMapping("/multiply")
    public String multiply(int num1, int num2, Model model){
        int result = num1 * num2;
        model.addAttribute("result", result);
        return "multiply";
    }
}
