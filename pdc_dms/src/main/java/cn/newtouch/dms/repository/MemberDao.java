package cn.newtouch.dms.repository;

import java.util.List;

import cn.newtouch.dms.entity.Member;

public interface MemberDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    
    Member findMemberByPdcId(String pdcId);
    
    List<Member> selectAll();
}