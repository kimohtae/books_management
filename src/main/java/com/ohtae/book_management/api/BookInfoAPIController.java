package com.ohtae.book_management.api;


import java.util.Map;

import com.ohtae.book_management.data.BookVO;
import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookInfoAPIController {
    @Autowired BookService service;


    @GetMapping("/book/bySeq")
    public BookVO getBookBySeq(@RequestParam Integer seq){
        return service.getBookBySeq(seq);
    }

    @PostMapping("/bookList/insert")
    public Map<String,Object> postBookListAdd(@RequestBody BookVO data){
        return service.postBookListAdd(data);
    }

    @PatchMapping("/bookList/update")
    public Map<String,Object> patchBookUpdate(@RequestBody BookVO data){
        return service.patchBookUpdate(data);
    }

    @DeleteMapping("/bookList/delete")
    public Map<String,Object> deleteBookListDelete(@RequestParam Integer seq){
        return service.deleteBookList(seq);
    }
}
