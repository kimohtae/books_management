package com.ohtae.book_management.data;

import java.sql.Date;

import lombok.Data;

@Data
public class AccountsVO {
    private Integer al_seq;
    private String al_name;
    private String al_address;
    private String al_email;
    private String al_phone;
    private String al_charge_person;
    private Date al_reg_dt;
    private Date al_mod_dt;
}
