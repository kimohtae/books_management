package com.ohtae.book_management.schedule;

import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class time_log_counts {
    @Autowired
    BookService service;

    @Scheduled(cron="0 1 0 * * *")
    public void insertTimeLogCounts(){
        for(int i=2; i<16; i++){
            Integer sellCnt=i;
            Integer likeCnt=i;
            Integer seq=i;
            service.insertTimeLogCounts(sellCnt, likeCnt,seq);
        }


    }
}
