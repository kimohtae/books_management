package com.ohtae.book_management.controller;

import com.ohtae.book_management.service.AccountService;
import com.ohtae.book_management.service.AdminMainService;
import com.ohtae.book_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired BookService Bservice;
    @Autowired AccountService Aservice;
    @Autowired AdminMainService AMservice;


    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("dayRank", Bservice.getDayRank());
        model.addAttribute("weekRank", Bservice.getWeekRank());
        model.addAttribute("monthRank", Bservice.getMonthRank());
        
        return "/index";
    }
    @GetMapping("/admin/page")
    public String getAdminBookMainPage(Model model){
        model.addAttribute("accountInfo", AMservice.getAccountCnt());
        model.addAttribute("bookInfo", AMservice.getBookCnt());
        return"/admin/adminMainPage";
    }
    @GetMapping("/admin/bookList")
    public String getAdminBookPage(
        Model model, 
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String keyword
        ){
        model.addAttribute("data", Bservice.getBookList(offset,keyword));
        model.addAttribute("category", Bservice.getCategoryList());
        return"/admin/adminBookList";
    }
    @GetMapping("/admin/accountList")
    public String getAdminAccountPage(
        Model model, 
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String keyword
        ){
        model.addAttribute("data", Aservice.getAccountList(offset,keyword));
        return"/admin/adminAccountList";
    }

}
