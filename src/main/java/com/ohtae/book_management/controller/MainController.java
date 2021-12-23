package com.ohtae.book_management.controller;


import com.ohtae.book_management.service.BookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired BookService Bservice;

    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("dayRank", Bservice.getDayRank());
        model.addAttribute("weekRank", Bservice.getWeekRank());
        model.addAttribute("monthRank", Bservice.getMonthRank());
        
        return "/index";
    }
}
