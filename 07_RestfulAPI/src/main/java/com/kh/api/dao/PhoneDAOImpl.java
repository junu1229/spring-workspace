package com.kh.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

@Repository
public class PhoneDAOImpl implements PhoneDAO{
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int insert(Phone phone) {
		return session.insert("phone.insert", phone);
	}

	@Override
	public Phone select(String num) {
		return (Phone) session.selectList("phone.select", num).get(0);
	}

	@Override
	public List<Phone> select() {
		return session.selectList("phone.select", null);
	}

	@Override
	public Userinfo select(Userinfo userinfo) {
		return session.selectOne("phone.selectUser", userinfo);
	}

	@Override
	public int update(Phone phone) {
		return session.update("phone.update", phone);
	}

	@Override
	public int delete(String num) {
		return session.delete("phone.delete", num);
	}

}
