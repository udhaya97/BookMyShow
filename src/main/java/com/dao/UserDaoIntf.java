package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.UserReg;

@Repository
public interface UserDaoIntf {
	void save(UserReg user);
	UserReg findByName(String name);
	UserReg findbyid(int id);
	
	List<UserReg> getAll();
}
