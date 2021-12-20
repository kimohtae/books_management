package com.ohtae.book_management.data;

import java.sql.Date;

import lombok.Data;

@Data
public class AccountInfoHistoryVO {
    private Integer alh_seq;
    private String alh_type;
    private String alh_content;
    private Date alh_reg_dt;
    private Integer alh_al_seq;
}
