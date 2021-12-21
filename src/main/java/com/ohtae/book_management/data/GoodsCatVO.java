package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsCatVO {
    private Integer gc_seq;
    private Date gc_reg_dt;
    private String gc_parent_category;
    private String gc_child_category;
}
