package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.BankAccount;

@Service
public interface BankServiceIntf {
	
	void save(BankAccount bAccount);
	List<BankAccount> fetAll();
	List<BankAccount> fetbyUserReg(int id);
	//BankAccount fetchByBname(String name);
	BankAccount fetchBybalandbid(double bal,int id);
	BankAccount fetbybnameanduid(String bname,int id);
}
