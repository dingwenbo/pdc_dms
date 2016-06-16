package cn.newtouch.dms.service;

import java.util.List;

import cn.newtouch.dms.entity.Member;

/**
 * 人员管理的Service.
 * 
 * @author JiaLong.Wang
 *
 */
public interface MemberService {
	Member findMemberByPdcId(String pdcId);
	Member selectMemberById(Integer id);
	void updateMember(Member member);
	void insertMember(Member member);
	void deleteMember(Integer id);
	List<Member> selectAll();
}
