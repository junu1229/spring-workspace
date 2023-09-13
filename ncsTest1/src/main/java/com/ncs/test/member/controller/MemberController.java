package com.ncs.test.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.ncs.test.member.model.service.MemberServiceImpl;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl serviceImpl;
	
	@PostMapping("login")
	public String memberLogin(HttpSession session, Member member, Model model) {
		Member target = serviceImpl.login(member);
		if(target!=null) {
			session.setAttribute("loginMember", target);
			return "redirect:/";
		}
		model.addAttribute("msg", "로그인 실패");
		return "redeirect:/errorPage";
	}

}
