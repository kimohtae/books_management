package com.ohtae.book_management.data;
import java.util.Date;

import lombok.Data;

@Data
public class BookCatVO {
    private Integer bc_seq;
    private String bc_parent_category;
    private String bc_child_category;
    private Date bc_reg_dt;
    private Date bc_mod_dt;
}
