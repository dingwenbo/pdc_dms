/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.web.member;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.entity.Role;
import cn.newtouch.dms.json.JsonUtils;
import cn.newtouch.dms.mapper.MemberMapper;
import cn.newtouch.dms.service.MemberService;
import cn.newtouch.dms.service.RoleService;
import cn.newtouch.dms.shiro.ShiroUser;
import cn.newtouch.dms.shiro.ShiroUtils;
import cn.newtouch.dms.util.StringUtil;
import cn.newtouch.dms.vo.member.MemberVO;
import cn.newtouch.dms.web.login.LoginController;

/**
 * 管理员管理用户的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

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

        ShiroUser userInfo = ShiroUtils.getCurrentUser();
        Member member = memberService.selectMemberById(userInfo.getId());
        Role role = roleService.getRoleById(member.getRoleId());

        MemberVO memberVo = MemberMapper.INSTANCE.memberAndRoleToMemberVo(member, role);
        return mv.addObject("memberVo", memberVo);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateMember(@PathVariable("id") Integer id, MemberVO memberVo) {
        Member memberUpdate = MemberMapper.INSTANCE.memberVOToMember(memberVo);

        Member member = memberService.selectMemberById(id);
        member.setGender(memberUpdate.getGender());
        member.setPhone(StringUtil.trimAllSpace(memberUpdate.getPhone()));
        member.setEmail(memberUpdate.getEmail());

        memberService.updateMember(member);
        LOGGER.info("更新用户" + member.getPdcId() + "成功");
        return JsonUtils.writeObject(String.valueOf(Boolean.TRUE));
    }

    @RequestMapping(value = "modifyPassword", method = RequestMethod.GET)
    public String modifyPassword() {
        return "member/modifypassword";
    }

    @RequestMapping(value = "modifyPassword", method = RequestMethod.POST)
    @ResponseBody
    public String modifyPassword(@RequestParam String confirmPassword) {
        ShiroUser userInfo = ShiroUtils.getCurrentUser();
        Member member = memberService.selectMemberById(userInfo.getId());
        member.setPlainPassword(confirmPassword);

        memberService.updateMember(member);
        LOGGER.info("用户" + member.getPdcId() + "更新密码成功");
        return JsonUtils.writeObject(String.valueOf(Boolean.TRUE));
    }

    @RequestMapping(value = "validatePassword", method = RequestMethod.POST)
    @ResponseBody
    public String validatePassword(@RequestParam String password) {
        String message = String.valueOf(Boolean.TRUE);
        ShiroUser userInfo = ShiroUtils.getCurrentUser();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getPdcId(), password);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            message = String.valueOf(Boolean.FALSE);
        }
        return JsonUtils.writeObject(message);
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
