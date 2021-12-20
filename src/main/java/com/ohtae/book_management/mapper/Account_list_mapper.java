package com.ohtae.book_management.mapper;

import java.util.List;

import com.ohtae.book_management.data.AccountInfoHistoryVO;
import com.ohtae.book_management.data.AccountVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Account_list_mapper {
    public List<AccountVO> getAccountList(Integer offset, String keyword);
    public AccountVO getAccountBySeq(Integer seq);
    public Integer getAccountCounts(String keyword);
    public Integer getLatestAccountHistorySeq();   
    public List<AccountVO> getAccountNameList(String keyword); 
    
    public void insertAccountInfo(AccountVO data);
    public void insertAccountInfoHistory(AccountInfoHistoryVO data);
    
    public void modifyAccountInfo(AccountVO data);
    
    public void deleteAccountList(Integer seq);
}
