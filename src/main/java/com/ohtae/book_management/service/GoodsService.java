package com.ohtae.book_management.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.book_management.data.GoodsCatVO;
import com.ohtae.book_management.data.GoodsInfoHistoryVO;
import com.ohtae.book_management.data.GoodsVO;
import com.ohtae.book_management.mapper.Goods_info_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoodsService {
    @Autowired Goods_info_mapper Gmapper;

    public Map<String,Object> getGoodsList(Integer offset, String keyword){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        
        if(offset==null)offset=0;
        if(keyword==null){
            keyword="%%";
            map.put("keyword", "");
        }else{
            map.put("keyword", keyword);
            keyword="%"+keyword+"%";
        }
        List<GoodsVO> list =Gmapper.getGoodsList(offset,keyword);
        Integer cnt = Gmapper.getGoodsCounts(keyword);
        Integer pages = cnt/20+(cnt%20>=1 ? 1:0);
        
        map.put("list", list);
        map.put("counts", cnt);
        map.put("pages", pages);
        return map;
    }
    
    public GoodsVO getGoodsBySeq(Integer seq){
        return Gmapper.getGoodsBySeq(seq);
    }
    
    public List<GoodsCatVO> getCategoryList(){
        return Gmapper.getCategoryList();
    }




    public Map<String,Object> insertGoodsInfo(GoodsVO data){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getGi_name().equals("") || data.getGi_name()==null){
            map.put("status", false);
            map.put("message", "이름을 입력하세요.");
            return map;
        }
        if(data.getGi_price()==0 || data.getGi_price()==null){
            map.put("status", false);
            map.put("message", "가격을 입력하세요.");
            return map;
        }
        if(data.getGi_al_seq()==0 || data.getGi_al_seq()==null){
            map.put("status", false);
            map.put("message", "제작사를 선택하세요.");
            return map;
        }
        if(data.getGi_gc_seq()==0 || data.getGi_gc_seq()==null){
            map.put("status", false);
            map.put("message", "카테고리를 선택하세요.");
            return map;
        }

        map.put("status", true);
        map.put("message", "추가 되었습니다.");
        Gmapper.insertGoodsInfo(data);

        GoodsInfoHistoryVO his = new GoodsInfoHistoryVO();
        his.setGih_gi_seq(Gmapper.getLatestGoodsHistorySeq());
        his.setGih_type("New");
        String cont = data.getGi_name() +"|"+ data.getGi_price() +"|"+ data.getGi_al_seq() +"|"+ data.getGi_gc_seq();
        his.setGih_content(cont);
        Gmapper.insertGoodsInfoHistory(his);
        return map;
    }

    public Map<String,Object> modifyGoodsInfo(GoodsVO data){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(data.getGi_name().equals("") || data.getGi_name()==null){
            map.put("status", false);
            map.put("message", "이름을 입력하세요.");
            return map;
        }
        if(data.getGi_price()==0 || data.getGi_price()==null){
            map.put("status", false);
            map.put("message", "가격을 입력하세요.");
            return map;
        }
        if(data.getGi_al_seq()==0 || data.getGi_al_seq()==null){
            map.put("status", false);
            map.put("message", "제작사를 선택하세요.");
            return map;
        }
        if(data.getGi_gc_seq()==0 || data.getGi_gc_seq()==null){
            map.put("status", false);
            map.put("message", "카테고리를 선택하세요.");
            return map;
        }
        
        GoodsInfoHistoryVO his = new GoodsInfoHistoryVO();
        his.setGih_gi_seq(data.getGi_seq());
        his.setGih_type("Update");
        String cont = data.getGi_name() +"|"+ data.getGi_price() +"|"+ data.getGi_al_seq() +"|"+ data.getGi_gc_seq();
        his.setGih_content(cont);
        Gmapper.insertGoodsInfoHistory(his);

        map.put("status", true);
        map.put("message", "변경 되었습니다.");
        Gmapper.modifyGoodsInfo(data);
        return map;
        
    }




    public Map<String,Object> deleteGoodsList(Integer seq){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        GoodsInfoHistoryVO his = new GoodsInfoHistoryVO();
        his.setGih_gi_seq(seq);
        his.setGih_type("Delete");
        Gmapper.insertGoodsInfoHistory(his);
        
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");
        Gmapper.deleteGoodsList(seq);
        return map;
    }
}
