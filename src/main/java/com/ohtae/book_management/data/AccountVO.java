package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class AccountVO {
    private Integer al_seq;
    private String al_name;
    private String al_charge_person;
    private String al_phone;
    private String al_email;
    private String al_address;
    private Integer al_status;
    private Date al_reg_dt;
}
