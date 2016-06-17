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
	
	/**
	 * 通过pdc id搜寻Member对象
	 * @param pdcId String
	 * @return Member
	 */
	Member findMemberByPdcId(String pdcId);
	
	/**
	 * 通过member自动生成的id搜寻Member对象
	 * @param id member的内置id
	 * @return Member
	 */
	Member selectMemberById(Integer id);
	
	/**
	 * 更新Member对象
	 * @param member Member
	 */
	void updateMember(Member member);
	
	/**
	 * 插入一个Member对象
	 * @param member Member
	 */
	void insertMember(Member member);
	
	/**
	 * 根据id删除一个Member对象
	 * @param id Integer
	 */
	void deleteMember(Integer id);
	
	/**
	 * 返回所有的Member对象.
	 * @return List&lt;Member&gt;
	 */
	List<Member> selectAll();
}
