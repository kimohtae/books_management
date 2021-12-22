package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class MemberInfoHistoryVO {
    private Integer mih_seq;
    private Integer mih_mi_seq;
    private String mih_type;
    private String mih_content;
    private Date mih_reg_dt;
}
