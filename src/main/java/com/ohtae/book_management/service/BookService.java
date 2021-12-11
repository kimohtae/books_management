package com.ohtae.book_management.service;


import java.util.List;


import com.ohtae.book_management.mapper.Time_log_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired Time_log_mapper mapper;

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
    
    
}
