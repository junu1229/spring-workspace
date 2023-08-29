package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	public int registerMember(Member vo) {
		return sqlsession.insert("memberMapper.registerMember", vo);
	}
	
	public Member signIn(Member vo) {
		return sqlsession.selectOne("memberMapper.signIn", vo);
	}
	
	public List<Member> allMember() {
		return sqlsession.selectList("memberMapper.allMember");
	}
	public List<Member> find(String keyword) {
		return sqlsession.selectList("memberMapper.find", keyword);
	}
	public int updateMember(Member member) {
		return sqlsession.update("memberMapper.updateMember", member);
	}
	
	/*
	 * 
	 * showAllMember
	 * findMember -> 파라미터 : String keyword, return List<Member>
	 * login -> 파라미터 : Member vo
	 * updateMember -> 파라미터 : Member vo
	 * 
	 */
}
