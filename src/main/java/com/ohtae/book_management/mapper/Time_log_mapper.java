package com.ohtae.book_management.mapper;



import java.util.List;



import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Time_log_mapper {
    public void insertTimeLogCounts(Integer sellCnt, Integer likeCnt,Integer seq);
    public List<String> getDayRank();
    public List<String> getWeekRank();
    public List<String> getMonthRank();
}
