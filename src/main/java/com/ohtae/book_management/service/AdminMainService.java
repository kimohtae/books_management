package com.ohtae.book_management.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohtae.book_management.mapper.Admin_main_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMainService {
    @Autowired Admin_main_mapper Amapper;

    public Map<String,Object> getAccountCnt(){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
            resultMap.put("total", Amapper.selectAccountTotalCnt());
            resultMap.put("trading", Amapper.selectAccountTradingCnt());
            resultMap.put("halted", Amapper.selectAccountHaltedCnt());
            resultMap.put("contracting", Amapper.selectAccountContractingCnt());
            resultMap.put("update",Amapper.selectAccountRecentUpdate());
        return resultMap;
    }
    
    public Map<String,Object> getBookCnt(){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
            resultMap.put("total", Amapper.selectBookTotalCnt());
            resultMap.put("sell", Amapper.selectBookSellCnt());
            resultMap.put("today", Amapper.selectBookTodaySellCnt());
            resultMap.put("week", Amapper.selectBookWeekSellCnt());
            resultMap.put("month", Amapper.selectBookMonthSellCnt());
            resultMap.put("update",Amapper.selectBookRecentUpdate());
        return resultMap;
    }
}
