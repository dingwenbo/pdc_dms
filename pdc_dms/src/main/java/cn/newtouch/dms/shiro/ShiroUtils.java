package cn.newtouch.dms.shiro;

import org.apache.shiro.SecurityUtils;

public final class ShiroUtils {
	
	public static ShiroUser getCurrentUser() {
		return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
	}
}
