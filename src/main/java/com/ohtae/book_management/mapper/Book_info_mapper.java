package com.ohtae.book_management.mapper;

import java.util.List;


import com.ohtae.book_management.data.BookCatVO;
import com.ohtae.book_management.data.BookInfoHistoryVO;
import com.ohtae.book_management.data.BookVO;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book_info_mapper {
    public List<BookVO> getBookList(Integer offset, String keyword);
    public BookVO getBookBySeq(Integer seq);
    public Integer getBookCounts(String keyword);
    public Integer getLatestBookHistorySeq();    
    public List<BookCatVO> getCategoryList();

    public void deleteBookList(Integer seq);
    public void insertBookInfo(BookVO data);
    public void insertBookInfoHistory(BookInfoHistoryVO data);
    public void modifyBookInfo(BookVO data);

    
}
