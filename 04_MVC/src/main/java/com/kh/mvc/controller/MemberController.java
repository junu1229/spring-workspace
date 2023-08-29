package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		List<Member> list = null;
		list = service.find(keyword);
		if(list.size()!=0) {
			model.addAttribute("list", list);
			return "find_ok";
		}
		
		return "find_fail"; // "find_fail" find_ok
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("signUp")
	public String signUp(Member member) {
		// 비즈니스 로직
		service.registerMember(member);
		return "redirect:/";
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("signIn")
	public String signIn(HttpSession session,Member member) {
		// 비즈니스 로직
		Member vo = null;
		vo = service.signIn(member);
		if(vo!=null) {
			session.setAttribute("vo", vo);
		}
		return "redirect:/";
	}
	
	@RequestMapping("allMember")
	public String allMember(Model model,Member member) {
		// 비즈니스 로직
		List<Member> list = null;
		list = service.allMember();
		if(list!=null) {
			model.addAttribute("list", list);
		}
		return "find_ok";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("vo");
		return "redirect:/";
	}
	// update - 페이지 이동
	@RequestMapping("update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("updateMember")
	public String updateMember(HttpSession session, Member member) {
		Member oldMem = (Member) session.getAttribute("vo");
		member.setId(oldMem.getId());
		System.out.println(member);
		service.updateMember(member);
		return "redirect:/";
	}
	
}
