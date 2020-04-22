package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.UserReg;
@Service
@Transactional
public class UserService implements UserServiceIntf {

	@Autowired
	UserDao uServ;
	
	@Override
	public void save(UserReg user) {
		uServ.save(user);

	}

	@Override
	public UserReg findByName(String name) {
		UserReg ug = uServ.findByName(name);
		return ug;
	}

	@Override
	public UserReg findbyid(int id) {
		UserReg ure =uServ.findbyid(id);
		return ure;
	}
	@Override
	public List<String> getUsernames() {
		List<UserReg> ureg = uServ.getAll();
		List<String> lis = new ArrayList<>();
		
		if(ureg.size()!=0)
		{
		for (UserReg userReg : ureg) {
			
			lis.add(userReg.getRole());
			
		}
		}
		return lis;
	}
}
