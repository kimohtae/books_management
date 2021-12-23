package com.ohtae.book_management.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.book_management.data.MemberInfoHistoryVO;
import com.ohtae.book_management.data.MemberVO;
import com.ohtae.book_management.mapper.Member_info_mapper;
import com.ohtae.book_management.utils.AESAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired Member_info_mapper Mmapper;

    public Map<String,Object> getMemberList(Integer offset, String keyword, String type){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        
        if(offset==null)offset=0;
        if(keyword==null){
            keyword="%%";
            map.put("keyword", "");
        }else{
            map.put("keyword", keyword);
            keyword="%"+keyword+"%";
        }

        List<MemberVO> list =Mmapper.getMemberList(offset, keyword, type);
        Integer cnt = Mmapper.getMemberCounts(keyword, type);
        Integer pages = cnt/20+(cnt%20>=1 ? 1:0);
        
        map.put("type", type);
        map.put("list", list);
        map.put("counts", cnt);
        map.put("pages", pages);
        return map;
    }

    public Map<String,Object> insertMemberInfo(MemberVO data)throws Exception{
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getMi_birth().equals("") || data.getMi_birth()==null){
            map.put("status", false);
            map.put("message", "생년월일을 입력하세요.");
            return map;
        }
        if(data.getMi_phone().equals("") || data.getMi_phone()==null){
            map.put("status", false);
            map.put("message", "전화번호를 입력하세요.");
            return map;
        }
        if(data.getMi_email().equals("") || data.getMi_email()==null){
            map.put("status", false);
            map.put("message", "이메일을 입력하세요.");
            return map;
        }
        if(data.getMi_address().equals("") || data.getMi_address()==null){
            map.put("status", false);
            map.put("message", "주소를 입력하세요.");
            return map;
        }
        if(data.getMi_status()==0 || data.getMi_status()==null){
            map.put("status", false);
            map.put("message", "상태를 선택하세요.");
            return map;
        }
        if(data.getMi_grade()==0 || data.getMi_grade()==null){
            map.put("status", false);
            map.put("message", "등급을 선택하세요.");
            return map;
        }
        
        map.put("status", true);
        map.put("message", "추가 되었습니다.");
        data.setMi_pwd(AESAlgorithm.Encrypt(data.getMi_pwd()));
        Mmapper.insertMemberInfo(data);

        MemberInfoHistoryVO his = new MemberInfoHistoryVO();
        his.setMih_mi_seq(Mmapper.getLatestMemberHistorySeq());
        his.setMih_type("New");
        String cont = data.getMi_name() +"|"+ data.getMi_id() +"|"+ data.getMi_birth() +"|"+ data.getMi_phone() +"|"+ data.getMi_email() +"|"+ data.getMi_address() +"|"+ data.getMi_status() +"|"+ data.getMi_grade();
        his.setMih_content(cont);
        Mmapper.insertMemberInfoHistory(his);
        return map;
    }

    public Map<String,Object> updateMemberStatus(Integer seq, Integer status){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        MemberInfoHistoryVO his = new MemberInfoHistoryVO();
        his.setMih_mi_seq(seq);
        his.setMih_type("Update(Status)");
        String cont = ""+status;
        his.setMih_content(cont);
        Mmapper.insertMemberInfoHistory(his);

        map.put("status", true);
        map.put("message", "변경 되었습니다.");
        Mmapper.updateMemberStatus(seq, status);
        return map;
    }
    public Map<String,Object> updateMemberGrade(Integer seq, Integer grade){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        MemberInfoHistoryVO his = new MemberInfoHistoryVO();
        his.setMih_mi_seq(seq);
        his.setMih_type("Update(Grade)");
        String cont = ""+grade;
        his.setMih_content(cont);
        Mmapper.insertMemberInfoHistory(his);

        map.put("status", true);
        map.put("message", "변경 되었습니다.");
        Mmapper.updateMemberGrade(seq, grade);
        return map;
    }




    public Map<String,Object> deleteMemberList(Integer seq){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        MemberInfoHistoryVO his = new MemberInfoHistoryVO();
        his.setMih_mi_seq(seq);
        his.setMih_type("Delete");
        Mmapper.insertMemberInfoHistory(his);
        
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");
        Mmapper.deleteMemberList(seq);
        return map;
    }
}
