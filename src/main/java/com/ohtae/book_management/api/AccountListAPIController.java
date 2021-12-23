package com.ohtae.book_management.api;


import java.util.Map;

import com.ohtae.book_management.data.AccountVO;
import com.ohtae.book_management.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountListAPIController {
    @Autowired AccountService service;


    @GetMapping("/account/bySeq")
    public AccountVO getAccountBySeq(@RequestParam Integer seq){
        return service.getAccountBySeq(seq);
    }
    @GetMapping("/accountList/byKeyword")
    public Map<String,Object> getAccountNameList(@RequestParam @Nullable String keyword){
        return service.getAccountNameList(keyword);
    }

    @PostMapping("/accountList/insert")
    public Map<String,Object> insertAccountInfo(@RequestBody AccountVO data){
        return service.insertAccountInfo(data);
    }

    @PatchMapping("/accountList/update")
    public Map<String,Object> modifyAccountInfo(@RequestBody AccountVO data){
        return service.modifyAccountInfo(data);
    }

    @DeleteMapping("/accountList/delete")
    public Map<String,Object> deleteAccountList(@RequestParam Integer seq){
        return service.deleteAccountList(seq);
    }
}
