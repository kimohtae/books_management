package com.ohtae.book_management.api;


import java.util.Map;

import com.ohtae.book_management.data.BookVO;
import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookInfoAPIController {
    @Autowired 
    BookService service;

    @DeleteMapping("/bookList/delete")
    public Map<String,Object> deleteBookListDelete(@RequestParam Integer seq){
        return service.deleteBookList(seq);
    }

    @PostMapping("/bookList/add")
    public Map<String,Object> postBookListAdd(@RequestBody BookVO data){
        return service.postBookListAdd(data);
    }
}
