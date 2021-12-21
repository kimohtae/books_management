package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class BookInfoHistoryVO {
    private Integer bih_seq;
    private String bih_type;
    private String bih_content;
    private Date bih_reg_dt;
    private Integer bih_bi_seq;
}
