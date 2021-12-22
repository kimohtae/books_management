package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
    private Integer mi_seq;
    private String mi_name;
    private String mi_id;
    private String mi_pwd;
    private String mi_birth;
    private String mi_phone;
    private String mi_email;
    private String mi_address;
    private Integer mi_status;
    private Integer mi_grade;
    private Date mi_reg_dt;

}
