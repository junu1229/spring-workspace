package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/all") 
	public void all() {}
	
	@GetMapping("/member")
	public void member() {}
	
	@GetMapping("/admin")
	public void admin() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/logout")
	public void logout() {}
	
	@GetMapping("/error")
	public void error() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(Member vo) {
		
		System.out.println("before password : " + vo.getPassword());
		
		// BCryptPasswordEncoder를 사용해서 암호화 처리
		String encodedPassword = bcpe.encode(vo.getPassword());
		System.out.println("after password : " + encodedPassword);
		
		vo.setPassword(encodedPassword);
		
		service.registerMember(vo);
		
		return "redirect:/member/login";
	}
	
}
