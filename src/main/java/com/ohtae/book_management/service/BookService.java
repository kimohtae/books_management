package com.ohtae.book_management.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.book_management.data.AccountsVO;
import com.ohtae.book_management.data.BookCatVO;
import com.ohtae.book_management.data.BookVO;
import com.ohtae.book_management.data.ImageBookVO;
import com.ohtae.book_management.mapper.Book_info_mapper;
import com.ohtae.book_management.mapper.Time_log_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired Time_log_mapper mapper;
    @Autowired Book_info_mapper Bmapper;

    public void insertTimeLogCounts(Integer sellCnt,Integer likeCnt, Integer seq){
        mapper.insertTimeLogCounts(sellCnt,likeCnt,seq);
    }
    public List<String> getDayRank(){
        return mapper.getDayRank();
    }
    public List<String> getWeekRank(){
        return mapper.getWeekRank();
    }
    public List<String> getMonthRank(){
        return mapper.getMonthRank();
    }
    public Map<String,Object> getBookList(Integer offset, String keyword){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        
        if(offset==null)offset=0;
        if(keyword==null){
            keyword="%%";
            map.put("keyword", "");
        }else{
            map.put("keyword", keyword);
            keyword="%"+keyword+"%";
        }
        List<BookVO> list =Bmapper.getBookList(offset,keyword);
        Integer cnt = Bmapper.getBookCounts(keyword);
        Integer pages = cnt/10+(cnt%10>=1 ? 1:0);
        map.put("list", list);
        map.put("counts", cnt);
        map.put("pages", pages);

        return map;
    }
    public BookVO getBookBySeq(Integer seq){
        return Bmapper.getBookBySeq(seq);
    }






    public Map<String,Object> deleteBookList(Integer seq){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");
        Bmapper.deleteBookList(seq);
        return map;
    }
    public Map<String,Object> postBookListAdd(BookVO data){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getBi_title().equals("") || data.getBi_title()==null){
            map.put("status", false);
            map.put("message", "제목을 입력해주세요.");
            return map;
        }
        if(data.getBi_author().equals("") || data.getBi_author()==null){
            map.put("status", false);
            map.put("message", "작가를 입력해주세요.");
            return map;
        }
        if(data.getBi_price()==0 || data.getBi_price()==null){
            map.put("status", false);
            map.put("message", "가격을 입력해주세요.");
            return map;
        }
        if(data.getBi_page()==0 || data.getBi_page()==null){
            map.put("status", false);
            map.put("message", "페이지 수를 입력해주세요.");
            return map;
        }
        if(data.getBi_al_seq()==0){
            map.put("status", false);
            map.put("message", "출판사를 선택해주세요.");
            return map;
        }
        if(data.getBi_ib_seq()==0){
            map.put("status", false);
            map.put("message", "이미지를 선택해주세요.");
            return map;
        }
        if(data.getBi_bc_seq()==0){
            map.put("status", false);
            map.put("message", "카테고리를 선택해주세요.");
            return map;
        }
        
        map.put("status", true);
        map.put("message", "추가 되었습니다.");
        Bmapper.insertBookInfo(data);
        return map;
        
    }

    public Map<String,Object> patchBookUpdate(BookVO data){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getBi_title().equals("") || data.getBi_title()==null){
            map.put("status", false);
            map.put("message", "제목을 입력해주세요.");
            return map;
        }
        if(data.getBi_author().equals("") || data.getBi_author()==null){
            map.put("status", false);
            map.put("message", "작가를 입력해주세요.");
            return map;
        }
        if(data.getBi_price()==0 || data.getBi_price()==null){
            map.put("status", false);
            map.put("message", "가격을 입력해주세요.");
            return map;
        }
        if(data.getBi_page()==0 || data.getBi_page()==null){
            map.put("status", false);
            map.put("message", "페이지 수를 입력해주세요.");
            return map;
        }
        if(data.getBi_al_seq()==0){
            map.put("status", false);
            map.put("message", "출판사를 선택해주세요.");
            return map;
        }
        if(data.getBi_ib_seq()==0){
            map.put("status", false);
            map.put("message", "이미지를 선택해주세요.");
            return map;
        }
        if(data.getBi_bc_seq()==0){
            map.put("status", false);
            map.put("message", "카테고리를 선택해주세요.");
            return map;
        }
        
        map.put("status", true);
        map.put("message", "변경 되었습니다.");
        Bmapper.modifyBookInfo(data);
        return map;
        
    }













    public List<AccountsVO> getAccountList(){
        return Bmapper.getAccountList();
    }
    public List<ImageBookVO> getImageList(){
        return Bmapper.getImageList();
    }
    public List<BookCatVO> getCategoryList(){
        return Bmapper.getCategoryList();
    }
    

    

}
