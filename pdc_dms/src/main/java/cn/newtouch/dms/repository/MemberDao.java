package cn.newtouch.dms.repository;

import java.util.List;

import cn.newtouch.dms.entity.Member;

public interface MemberDao {
    int deleteById(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectById(Integer id);

    int updateSelective(Member record);

    int update(Member record);
    
    Member selectByPdcId(String pdcId);
    
    List<Member> selectAll();
}