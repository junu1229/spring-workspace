package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	
	public int registerMember(Member vo) {
		return dao.registerMember(vo);
	}
	
	public Member signIn(Member vo) {
		return dao.signIn(vo);
	}
	public List<Member> allMember() {
		return dao.allMember();
	}
	public List<Member> find(String keyword) {
		return dao.find(keyword);
	}
	public int updateMember(Member member) {
		return dao.updateMember(member);
	}
	
	
}
