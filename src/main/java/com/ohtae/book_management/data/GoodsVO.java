package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsVO {
    private Integer gi_seq;
    private Integer gi_al_seq;
    private Integer gi_gc_seq;

    private String gi_name;
    private Integer gi_price;
    private Date gi_reg_dt;

    private String gi_catP;
    private String gi_catC;

    private Integer gi_sell;
    private Integer gi_stock;
    private Integer gi_like;
    
    private String gi_account;

}
