package com.ohtae.book_management.data;

import java.sql.Date;

import lombok.Data;
@Data
public class ImageBookVO {
    private Integer ib_seq;
    private Integer ib_bi_seq;
    private String ib_image;
    private Date ib_reg_dt;
    private Date ib_sold_dt;   
}
