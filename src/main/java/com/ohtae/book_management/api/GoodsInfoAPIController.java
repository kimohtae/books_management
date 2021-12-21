package com.ohtae.book_management.api;

import java.util.Map;

import com.ohtae.book_management.data.GoodsVO;
import com.ohtae.book_management.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsInfoAPIController {
    @Autowired GoodsService service;


    @GetMapping("/goods/bySeq")
    public GoodsVO getGoodsBySeq(@RequestParam Integer seq){
        return service.getGoodsBySeq(seq);
    }

    @PostMapping("/goodsList/insert")
    public Map<String,Object> insertGoodsInfo(@RequestBody GoodsVO data){
        return service.insertGoodsInfo(data);
    }

    @PatchMapping("/goodsList/update")
    public Map<String,Object> modifyGoodsInfo(@RequestBody GoodsVO data){
        return service.modifyGoodsInfo(data);
    }

    @DeleteMapping("/goodsList/delete")
    public Map<String,Object> deleteGoodsList(@RequestParam Integer seq){
        return service.deleteGoodsList(seq);
    }
}
