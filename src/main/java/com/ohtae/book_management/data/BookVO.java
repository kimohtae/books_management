package com.ohtae.book_management.data;

import java.sql.Date;

import lombok.Data;

@Data
public class BookVO {
    private Integer bi_seq;
    private Integer bi_al_seq;
    private Integer bi_ib_seq;
    private String bi_title;
    private String bi_publisher;
    private String bi_author;
    private Integer bi_page;
    private Integer bi_price;
    private Integer bi_type;
    private Integer bi_stock;
    private Integer bi_like;
    private Date bi_reg_dt;
    private Date bi_mod_dt;
}
