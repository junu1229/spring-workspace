package com.ncs.test.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public Member logIn(Member member) {
		return sessionTemplate.selectOne("member-mapper.loginMember", member);
	}
	
}
