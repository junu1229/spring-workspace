package com.kh.api.service;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

public interface PhoneService {
	int insert(Phone phone);
	int update(Phone phone);
	int delete(String num);
	Phone select(String num);
	List<Phone> select();
	Userinfo select(Userinfo userinfo);
}
