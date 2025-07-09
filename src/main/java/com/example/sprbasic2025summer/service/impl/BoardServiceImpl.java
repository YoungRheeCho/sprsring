package com.example.sprbasic2025summer.service.impl;

import com.example.sprbasic2025summer.domain.Board;
import com.example.sprbasic2025summer.repository.BoardRepository;
import com.example.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;
    /*List<Map<String,Object>> list = new ArrayList<>();
    int tempId = 0;*/

    @Override
    public Map<String, Object> create(@RequestParam Map<String, Object> param) {
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        System.out.println("check");
        Board board = Board.of(title, content, author);
        boardRepository.save(board);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);

        /*Map<String,Object> map_board = new HashMap<>();
        map_board.put("id",++tempId);
        map_board.put("title",title);
        map_board.put("content",content);
        map_board.put("author",author);
        list.add(map_board);

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code",200);
        map_result.put("total_size",list.size());*/
        return map_result;
    }

    @Override
    public Map<String, Object> list() {
        List<Board> list = boardRepository.findAll();
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("list", list);

        /*Map<String,Object> map_result = new HashMap<>();
        map_result.put("code",200);
        map_result.put("total_size",list.size());
        map_result.put("list",list);*/
        return map_result;
    }

    @Override
    public Map<String, Object> detail(long id) {
        Board board = boardRepository.findById(id).orElseThrow(()->new RuntimeException("no data"));

        int resultCode = 200;
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("board", board);
        /*Map<String,Object> map_board = null;
        for(Map<String,Object> each:list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId==id){
                map_board = each;
            }
        }

        int resultCode = 0;
        if(map_board!=null){
            resultCode=200;
        }*/

        //Map<String,Object> map_result = new HashMap<>();

        return map_result;
    }

    @Override
    public Map<String, Object> update(int id, Map<String, Object> param) {
        int code = 200;
        Board board = boardRepository.findById((long)id).orElseThrow(()->new RuntimeException("no data"));
        if(param.get("title")!=null){
            board.setTitle((String)param.get("title"));
        }
        if(param.get("content")!=null){
            board.setContent((String)param.get("content"));
        }
        if(param.get("author")!=null){
            board.setAuthor((String)param.get("author"));
        }

        boardRepository.save(board);
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        return map_result;
        /*int r_id = Integer.parseInt(param.get("id").toString());
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

        return list();*/
    }

    @Override
    public Map<String, Object> delete(int id) {
        Board board = boardRepository.findById((long)id).orElseThrow(()->new RuntimeException("no data"));
        boardRepository.delete(board);
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        return map_result;
        /*Iterator<Map<String, Object>> iterator = list.iterator();
        while(iterator.hasNext()){
            Map<String, Object> item = iterator.next();
            int item_id = Integer.parseInt(item.get("id").toString());
            if(item_id == id){
                iterator.remove();
            }
        }
        return list();*/
    }
}
