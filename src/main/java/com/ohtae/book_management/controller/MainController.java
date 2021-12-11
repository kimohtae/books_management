package com.ohtae.book_management.controller;

import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
