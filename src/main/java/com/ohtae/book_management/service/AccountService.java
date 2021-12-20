package com.ohtae.book_management.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.book_management.data.AccountInfoHistoryVO;
import com.ohtae.book_management.data.AccountVO;
import com.ohtae.book_management.mapper.Account_list_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired Account_list_mapper Amapper;


    public Map<String,Object> getAccountList(Integer offset, String keyword){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        
        if(offset==null)offset=0;
        if(keyword==null){
            keyword="%%";
            map.put("keyword", "");
        }else{
            map.put("keyword", keyword);
            keyword="%"+keyword+"%";
        }
        List<AccountVO> list =Amapper.getAccountList(offset,keyword);
        Integer cnt = Amapper.getAccountCounts(keyword);
        Integer pages = cnt/10+(cnt%10>=1 ? 1:0);
        
        map.put("list", list);
        map.put("pages", pages);
        return map;
    }

    public AccountVO getAccountBySeq(Integer seq){
        return Amapper.getAccountBySeq(seq);
    }

    public Map<String,Object> getAccountNameList(String keyword){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(keyword==null){
            keyword="%%";
        }else{
            keyword="%"+keyword+"%";
        }
        map.put("list", Amapper.getAccountNameList(keyword));
        return map;
    }




    public Map<String,Object> insertAccountInfo(AccountVO data){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getAl_name().equals("") || data.getAl_name()==null){
            map.put("status", false);
            map.put("message", "출판사를 입력해주세요.");
            return map;
        }
        if(data.getAl_charge_person().equals("") || data.getAl_charge_person()==null){
            map.put("status", false);
            map.put("message", "담당자를 입력해주세요.");
            return map;
        }
        if(data.getAl_phone().equals("") || data.getAl_phone()==null){
            map.put("status", false);
            map.put("message", "전화번호를 입력해주세요.");
            return map;
        }
        if(data.getAl_email().equals("") || data.getAl_email()==null){
            map.put("status", false);
            map.put("message", "이메일을 입력해주세요.");
            return map;
        }
        if(data.getAl_address().equals("") || data.getAl_address()==null){
            map.put("status", false);
            map.put("message", "주소를 입력해주세요.");
            return map;
        }

        map.put("status", true);
        map.put("message", "추가 되었습니다.");
        Amapper.insertAccountInfo(data);

        AccountInfoHistoryVO his = new AccountInfoHistoryVO();
        his.setAlh_al_seq(Amapper.getLatestAccountHistorySeq());
        his.setAlh_type("new");
        String cont = data.getAl_name() +"|"+ data.getAl_charge_person() +"|"+ data.getAl_email() +"|"+ data.getAl_phone() +"|"+ data.getAl_address() +"|"+ data.getAl_status();
        his.setAlh_content(cont);
        Amapper.insertAccountInfoHistory(his);

        return map;
        
    }

    public Map<String,Object> modifyAccountInfo(AccountVO data){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getAl_name().equals("") || data.getAl_name()==null){
            map.put("status", false);
            map.put("message", "출판사를 입력해주세요.");
            return map;
        }
        if(data.getAl_charge_person().equals("") || data.getAl_charge_person()==null){
            map.put("status", false);
            map.put("message", "담당자를 입력해주세요.");
            return map;
        }
        if(data.getAl_phone().equals("") || data.getAl_phone()==null){
            map.put("status", false);
            map.put("message", "전화번호를 입력해주세요.");
            return map;
        }
        if(data.getAl_email().equals("") || data.getAl_email()==null){
            map.put("status", false);
            map.put("message", "이메일을 입력해주세요.");
            return map;
        }
        if(data.getAl_address().equals("") || data.getAl_address()==null){
            map.put("status", false);
            map.put("message", "주소를 입력해주세요.");
            return map;
        }
        
        map.put("status", true);
        map.put("message", "변경 되었습니다.");
        Amapper.modifyAccountInfo(data);
        
        AccountInfoHistoryVO his = new AccountInfoHistoryVO();
        his.setAlh_al_seq(data.getAl_seq());
        his.setAlh_type("update");
        String cont = data.getAl_name() +"|"+ data.getAl_charge_person() +"|"+ data.getAl_email() +"|"+ data.getAl_phone() +"|"+ data.getAl_address() +"|"+ data.getAl_status();
        his.setAlh_content(cont);
        Amapper.insertAccountInfoHistory(his);

        return map;
        
    }




    public Map<String,Object> deleteAccountList(Integer seq){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        
        try{
            Amapper.deleteAccountList(seq);
            map.put("status", true);
            map.put("message", "삭제가 완료 되었습니다.");
        }catch(Exception e){
            map.put("status", false);
            map.put("message", "회사가 판매하는 책 또는 굿즈가 존재합니다.");
        }
        
        AccountInfoHistoryVO his = new AccountInfoHistoryVO();
        his.setAlh_al_seq(seq);
        his.setAlh_type("delete");
        Amapper.insertAccountInfoHistory(his);
        
        return map;
    }


}
