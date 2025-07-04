package com.example.sprbasic2025summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/"+page;
    }
}
