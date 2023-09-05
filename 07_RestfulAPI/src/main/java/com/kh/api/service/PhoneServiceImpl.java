package com.kh.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.api.dao.PhoneDAO;
import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

@Service
public class PhoneServiceImpl implements PhoneService{
	
	@Autowired
	private PhoneDAO dao;

	@Override
	public int insert(Phone phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Phone select(Phone phone) {
		return dao.select(phone);
	}

	@Override
	public List<Phone> select() {
		return dao.select();
	}

	@Override
	public Userinfo select(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
