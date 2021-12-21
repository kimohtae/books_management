package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class TimeLogCountsVO {
    private Integer tlc_seq;
    private Integer tlc_bi_seq;
    private Integer tlc_sell_count;
    private Integer tlc_like_count;
    private Date tlc_reg_dt;
}
