package com.ohtae.book_management.data;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsInfoHistoryVO {
    Integer gih_seq;
    Integer gih_gi_seq;
    String gih_type;
    String gih_content;
    Date gih_reg_dt;
}
