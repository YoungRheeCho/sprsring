package com.example.sprbasic2025summer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


public interface BoardService {
    Map<String, Object> create(Map<String, Object> param);
    public Map<String,Object> list();
    public Map<String,Object> detail(@PathVariable("id") long id);
    public Map<String, Object> update(@PathVariable("id") int id, @RequestParam Map<String,Object> param);
    public Map<String,Object> delete(@PathVariable("id") int id);
}
