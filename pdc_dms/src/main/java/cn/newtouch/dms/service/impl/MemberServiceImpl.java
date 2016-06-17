package cn.newtouch.dms.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Clock;
import org.springside.modules.utils.Encodes;

import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.repository.MemberDao;
import cn.newtouch.dms.service.MemberService;
import cn.newtouch.dms.service.ServiceException;
import cn.newtouch.dms.service.impl.ShiroDbRealm.ShiroUser;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	private Clock clock = Clock.DEFAULT;
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		logger.info("初始化MemberService实例...");
	}
	
	@Override
	public Member findMemberByPdcId(String pdcId) {
		return memberDao.findMemberByPdcId(pdcId);
	}
	@Override
	public Member selectMemberById(Integer id) {
		return memberDao.selectByPrimaryKey(id);
	}

	public void insertMember(Member member) {
		entryptPassword(member);
		member.setRegisterDate(clock.getCurrentDate());

		memberDao.insert(member);
	}

	public void updateMember(Member member) {
		if (StringUtils.isNotBlank(member.getPlainPassword())) {
			entryptPassword(member);
		}
		memberDao.updateByPrimaryKey(member);
	}
	
	public List<Member> selectAll() {
		return memberDao.selectAll();
	}
	
	public void deleteMember(Integer id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		memberDao.deleteByPrimaryKey(id);
	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Integer id) {
		Member member = memberDao.selectByPrimaryKey(id);
		
		return member != null && member.getRoleId() == 1;
	}
	
	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.pdcId;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(Member member) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		member.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(member.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		member.setPassword(Encodes.encodeHex(hashPassword));
	}

}
