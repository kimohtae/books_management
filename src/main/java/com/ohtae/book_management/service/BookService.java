package com.ohtae.book_management.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.book_management.data.BookCatVO;
import com.ohtae.book_management.data.BookVO;
import com.ohtae.book_management.mapper.Book_info_mapper;
import com.ohtae.book_management.mapper.Time_log_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired Time_log_mapper mapper;
    @Autowired Book_info_mapper Bmapper;

    public void insertTimeLogCounts(Integer sellCnt,Integer likeCnt, Integer seq){
        mapper.insertTimeLogCounts(sellCnt,likeCnt,seq);
    }
    public List<String> getDayRank(){
        return mapper.getDayRank();
    }
    public List<String> getWeekRank(){
        return mapper.getWeekRank();
    }
    public List<String> getMonthRank(){
        return mapper.getMonthRank();
    }
    public Map<String,Object> getBookList(Integer offset){
        Map<String,Object> map = new LinkedHashMap<String,Object>();

        if(offset==null)offset=0;
        List<BookVO> list =Bmapper.getBookList(offset);
        Integer cnt = Bmapper.getBookCounts();
        Integer pages = cnt/10+(cnt%10>=1 ? 1:0);
        map.put("list", list);
        map.put("counts", cnt);
        map.put("pages", pages);

        return map;
    }
    public Map<String,Object> deleteBookList(Integer seq){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");
        Bmapper.deleteBookList(seq);
        return map;
    }
    public List<BookCatVO> getBookCat(){
        
        return Bmapper.getBookCat();
    }
    
}
