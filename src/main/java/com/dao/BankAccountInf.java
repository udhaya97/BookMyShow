package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.BankAccount;

@Repository

public interface BankAccountInf {
	
	
	void save(BankAccount bAcct);
	List<BankAccount> fethAll();
	List<BankAccount> fetbyUserReg(int id);
	//BankAccount fetchBybName(String name);
	BankAccount fetchBybalandbid(double bal,int id);
	BankAccount fetbybnameanduid(String bname,int id);

}
