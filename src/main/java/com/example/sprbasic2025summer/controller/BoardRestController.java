package com.example.sprbasic2025summer.controller;

import com.example.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    final BoardService boardService;
    /*BoardRestController(BoardService boardService){
        this.boardService = boardService;
    }*/

    @RequestMapping("/create")
    public Map<String,Object> create(@RequestParam Map<String,Object> param){
        return boardService.create(param);
    }

    @RequestMapping("/list")
    public Map<String,Object> list(){
        return boardService.list();
    }

    @RequestMapping("/detail/{id}")
    public Map<String,Object> detail(@PathVariable("id") int id){
        return boardService.detail(id);
    }

    @RequestMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable("id") int id, @RequestParam Map<String,Object> param){
        return boardService.update(id, param);
    }

    @RequestMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") int id){
        return boardService.delete(id);
    }
}
