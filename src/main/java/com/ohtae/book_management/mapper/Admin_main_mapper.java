package com.ohtae.book_management.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Admin_main_mapper {
    public Integer selectAccountTotalCnt();
    public Integer selectAccountTradingCnt();
    public Integer selectAccountHaltedCnt();
    public Integer selectAccountContractingCnt();
    public Date selectAccountRecentUpdate();
    
    
    public Integer selectBookTotalCnt();
    public Integer selectBookSellCnt();
    public Integer selectBookTodaySellCnt();
    public Integer selectBookWeekSellCnt();
    public Integer selectBookMonthSellCnt();
    public Date selectBookRecentUpdate();
}
