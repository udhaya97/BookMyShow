package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.model.UserReg;

@Service
@Transactional
public interface UserServiceIntf {
	void save(UserReg user);
	UserReg findByName(String name);
	UserReg findbyid(int id);
	List<String> getUsernames();

}
