package com.example.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    List<Map<String,Object>> list = new ArrayList<>();
    int tempId = 0;

    @RequestMapping("/create")
    public Map<String,Object> create(
            //@RequestParam String title, String content
            @RequestParam Map<String,Object> param
        ){
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        /*System.out.println("title:"+title);
        System.out.println("content:"+content);
        System.out.println("author:"+author);*/

        Map<String,Object> map_board = new HashMap<>();
        map_board.put("id",++tempId);
        map_board.put("title",title);
        map_board.put("content",content);
        map_board.put("author",author);
        list.add(map_board);

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code",200);
        map_result.put("total_size",list.size());
        return map_result;
    }

    @RequestMapping("/list")
    public Map<String,Object> list(){
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code",200);
        map_result.put("total_size",list.size());
        map_result.put("list",list);
        return map_result;
    }

    @RequestMapping("/detail/{id}")
    public Map<String,Object> detail(@PathVariable("id") int id){
        Map<String,Object> map_board = null;
        for(Map<String,Object> each:list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId==id){
                map_board = each;
            }
        }

        int resultCode = 0;
        if(map_board!=null){
            resultCode=200;
        }

        //Map<String,Object> map_result = new HashMap<>();

        return map_board;
    }

    @RequestMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable("id") int id, @RequestParam Map<String,Object> param){
        int r_id = Integer.parseInt(param.get("id").toString());
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        System.out.println("id:"+id);
        System.out.println("title:"+title);
        System.out.println("content:"+content);
        System.out.println("author:"+author);

        int cnt = 0;
        for(Map<String,Object> each:list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId==id){
                list.set(cnt,param);
            }
            cnt++;
        }

        return list();
    }

    @RequestMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") int id){
        Iterator<Map<String, Object>> iterator = list.iterator();
        while(iterator.hasNext()){
            Map<String, Object> item = iterator.next();
            int item_id = Integer.parseInt(item.get("id").toString());
            if(item_id == id){
                iterator.remove();
            }
        }
        return list();
    }
}
