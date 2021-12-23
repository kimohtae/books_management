package com.ohtae.book_management.api;

import java.util.Map;

import com.ohtae.book_management.data.MemberVO;
import com.ohtae.book_management.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberInfoAPIController {
    @Autowired MemberService service;

    @PostMapping("/member/insert")
    public Map<String,Object> insertMemberInfo(@RequestBody MemberVO data)throws Exception{
        return service.insertMemberInfo(data);
    }

    @PatchMapping("/member/update/status")
    public Map<String,Object> updateMemberStatus(@RequestParam Integer seq, @RequestParam Integer status){
        return service.updateMemberStatus(seq, status);
    }
    @PatchMapping("/member/update/grade")
    public Map<String,Object> updateMemberGrade(@RequestParam Integer seq, @RequestParam Integer grade){
        return service.updateMemberGrade(seq, grade);
    }

    @DeleteMapping("/member/delete")
    public Map<String,Object> deleteMemberList(@RequestParam Integer seq){
        return service.deleteMemberList(seq);
    }
}

