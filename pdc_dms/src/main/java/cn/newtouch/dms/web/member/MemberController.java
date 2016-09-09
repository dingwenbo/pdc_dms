/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.web.member;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.entity.Role;
import cn.newtouch.dms.mapper.MemberMapper;
import cn.newtouch.dms.service.MemberService;
import cn.newtouch.dms.service.RoleService;
import cn.newtouch.dms.shiro.ShiroUser;
import cn.newtouch.dms.util.StringUtil;
import cn.newtouch.dms.vo.MemberVo;

/**
 * 管理员管理用户的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

    @Autowired
    private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> members = memberService.selectAll();
		model.addAttribute("members", members);

		return "member/adminMemberList";
	}

    // @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    // public String updateForm(@PathVariable("id") Integer id, Model model) {
    // model.addAttribute("member", memberService.selectMemberById(id));
    // return "member/adminMemberForm";
    // }

    // @RequestMapping(value = "update", method = RequestMethod.POST)
    // public String update(@Valid @ModelAttribute("member") Member member, RedirectAttributes redirectAttributes) {
    // memberService.updateMember(member);
    // redirectAttributes.addFlashAttribute("message", "更新用户" + member.getPdcId() + "成功");
    // return "redirect:/admin/member";
    // }

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		Member member = memberService.selectMemberById(id);
		memberService.deleteMember(id);
		redirectAttributes.addFlashAttribute("message", "删除用户" + member.getPdcId() + "成功");
		return "redirect:/admin/member";
	}

    @RequestMapping(value = "memberInfo", method = RequestMethod.GET)
    public ModelAndView showMemberInfo() {
        ModelAndView mv = new ModelAndView("member/memberinfo");

        ShiroUser userInfo = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        Member member = memberService.selectMemberById(userInfo.getId());
        Role role = roleService.getRoleById(member.getRoleId());

        MemberVo memberVo = MemberMapper.INSTANCE.memberAndRoleToMemberVo(member, role);
        return mv.addObject("memberVo", memberVo);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateMember(@PathVariable("id") Integer id, MemberVo memberVo) {
        Member memberUpdate = MemberMapper.INSTANCE.memberVoToMember(memberVo);

        Member member = memberService.selectMemberById(id);
        member.setGender(memberUpdate.getGender());
        member.setSupervisorId(memberUpdate.getSupervisorId());
        member.setBackup(memberUpdate.isBackup());
        member.setPhone(StringUtil.trimAllSpace(memberUpdate.getPhone()));

        memberService.updateMember(member);

        return "redirect:/login/success";
    }

	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Member对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void selectMemberById(@RequestParam(value = "id", defaultValue = "-1") Integer id, Model model) {
		if (id != -1) {
			model.addAttribute("member", memberService.selectMemberById(id));
		}
	}
}
