package com.ohtae.book_management.mapper;

import java.util.List;

import com.ohtae.book_management.data.BookCatVO;
import com.ohtae.book_management.data.BookVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book_info_mapper {
    public List<BookVO> getBookList(Integer offset);
    public Integer getBookCounts();
    public void deleteBookList(Integer seq);
    public BookVO insertBookInfo();


    public List<BookCatVO> getBookCat();
}
