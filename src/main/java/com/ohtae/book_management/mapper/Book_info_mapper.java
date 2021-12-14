package com.ohtae.book_management.mapper;

import java.util.List;

import com.ohtae.book_management.data.AccountsVO;
import com.ohtae.book_management.data.BookCatVO;
import com.ohtae.book_management.data.BookVO;
import com.ohtae.book_management.data.ImageBookVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book_info_mapper {
    public List<BookVO> getBookList(Integer offset, String keyword);
    public BookVO getBookBySeq(Integer seq);
    public Integer getBookCounts(String keyword);
    

    public void deleteBookList(Integer seq);
    public void insertBookInfo(BookVO data);
    public void modifyBookInfo(BookVO data);

    public List<AccountsVO> getAccountList();
    public List<ImageBookVO> getImageList();
    public List<BookCatVO> getCategoryList();
    
}
