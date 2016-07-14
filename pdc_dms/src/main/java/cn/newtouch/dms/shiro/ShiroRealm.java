/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.shiro;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springside.modules.utils.Encodes;

import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.entity.Role;
import cn.newtouch.dms.service.MemberService;
import cn.newtouch.dms.service.RoleService;
import cn.newtouch.dms.service.impl.MemberServiceImpl;

/**
 * Shiro 权限验证。
 * @author JiaLong.Wang
 *
 */
public class ShiroRealm extends AuthorizingRealm {

	protected MemberService memberService;

	protected RoleService roleService;
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Member member = memberService.findMemberByPdcId(token.getUsername());
		if (member != null) {
			byte[] salt = Encodes.decodeHex(member.getSalt());
			return new SimpleAuthenticationInfo(new ShiroUser(member.getId(), member.getPdcId(), member.getName()),
					member.getPassword(), ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		Member member = memberService.findMemberByPdcId(shiroUser.pdcId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Role role = roleService.getRoleById(member.getRoleId());
		if (role != null) {
			info.addRole(role.getCode());
		}
		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(MemberServiceImpl.HASH_ALGORITHM);
		matcher.setHashIterations(MemberServiceImpl.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
