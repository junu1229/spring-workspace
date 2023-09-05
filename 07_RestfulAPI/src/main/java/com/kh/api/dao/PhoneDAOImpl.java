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
		return 0;
	}

	@Override
	public int delete(List<String> list) {
		return 0;
	}

	@Override
	public Phone select(Phone phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> select() {
		return session.selectList("phoneMapper.select");
	}

	@Override
	public Userinfo select(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
