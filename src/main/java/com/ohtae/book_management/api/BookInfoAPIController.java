package com.ohtae.book_management.api;


import java.util.Map;

import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookInfoAPIController {
    @Autowired 
    BookService service;

    @DeleteMapping("/delete/bookList")
    public Map<String,Object> deleteBookList(@RequestParam Integer seq){
        return service.deleteBookList(seq);
    }
}
