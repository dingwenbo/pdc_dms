/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.service.MemberService;

/**
 * 用户注册的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm() {
		return "member/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid Member member, RedirectAttributes redirectAttributes) {
		memberService.insertMember(member);
		redirectAttributes.addFlashAttribute("username", member.getPdcId());
		return "redirect:/login";
	}

	/**
	 * Ajax请求校验loginName是否唯一。
	 */
	@RequestMapping(value = "checkPdcId")
	@ResponseBody
	public String checkLoginName(@RequestParam("pdcId") String pdcId) {
		if (memberService.findMemberByPdcId(pdcId) == null) {
			return "true";
		} else {
			return "false";
		}
	}
}
