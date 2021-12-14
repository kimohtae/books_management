package com.ohtae.book_management.controller;

import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired 
    BookService service;
    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("dayRank", service.getDayRank());
        model.addAttribute("weekRank", service.getWeekRank());
        model.addAttribute("monthRank", service.getMonthRank());
        
        return "/index";
    }
    @GetMapping("/admin/book")
    public String getAdminBookPage(
        Model model, 
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String keyword
        ){
        model.addAttribute("data", service.getBookList(offset,keyword));
        model.addAttribute("account", service.getAccountList());
        model.addAttribute("image", service.getImageList());
        model.addAttribute("category", service.getCategoryList());
        return"/adminBookList";
    }

}
