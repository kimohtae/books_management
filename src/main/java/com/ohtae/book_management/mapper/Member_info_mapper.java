package com.ohtae.book_management.mapper;

import java.util.List;

import com.ohtae.book_management.data.MemberInfoHistoryVO;
import com.ohtae.book_management.data.MemberVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Member_info_mapper {
    public List<MemberVO> getMemberList(Integer offset, String keyword, String type);
    public Integer getMemberCounts(String keyword, String type);
    public Integer getLatestMemberHistorySeq();    

    public void deleteMemberList(Integer seq);
    public void insertMemberInfo(MemberVO data);
    public void insertMemberInfoHistory(MemberInfoHistoryVO data);
    public void updateMemberStatus(Integer seq, Integer status);
    public void updateMemberGrade(Integer seq, Integer grade);
}
