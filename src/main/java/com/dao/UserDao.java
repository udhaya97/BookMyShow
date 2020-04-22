package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UserReg;
import com.repo.RegRepo;
@Repository
public class UserDao implements UserDaoIntf {

	@Autowired
	RegRepo uDao;
	@Override
	public void save(UserReg user) {
	
		uDao.save(user);
		

	}
	@Override
	public UserReg findByName(String name) {
		
		UserReg usr=uDao.findByUName(name);
		
		return usr;
	}
	@Override
	public UserReg findbyid(int id) {
		UserReg ure =uDao.findByuId(id);
		
		return ure;
	}
	@Override
	public List<UserReg> getAll() {
		List<UserReg> getVals = (List<UserReg>) uDao.findAll();
		
		return getVals;
	}

}
