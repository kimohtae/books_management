package com.ohtae.book_management.mapper;

import java.util.List;


import com.ohtae.book_management.data.GoodsCatVO;
import com.ohtae.book_management.data.GoodsInfoHistoryVO;
import com.ohtae.book_management.data.GoodsVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Goods_info_mapper {
    public List<GoodsVO> getGoodsList(Integer offset, String keyword);
    public GoodsVO getGoodsBySeq(Integer seq);
    public Integer getGoodsCounts(String keyword);
    public Integer getLatestGoodsHistorySeq();    
    public List<GoodsCatVO> getCategoryList();

    public void insertGoodsInfo(GoodsVO data);
    public void insertGoodsInfoHistory(GoodsInfoHistoryVO data);
    public void modifyGoodsInfo(GoodsVO data);
    public void deleteGoodsList(Integer seq);
}
