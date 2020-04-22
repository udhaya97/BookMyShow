package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.BankAccount;
import com.repo.BankRepo;

@Repository
public class BankAccountDao implements BankAccountInf{

	@Autowired
	BankRepo bRepo;
	@Override
	public void save(BankAccount bAcct) {
		bRepo.save(bAcct);
		
	}

	@Override
	public List<BankAccount> fethAll() {
		List<BankAccount> bAccount =(List<BankAccount>) bRepo.findAll();
		return bAccount;
	}

	@Override
	public List<BankAccount> fetbyUserReg(int id) {
		
		List<BankAccount> bAct =bRepo.findByUserReg(id);
		return bAct;
	}

	/*
	 * @Override public BankAccount fetchBybName(String name) {
	 * System.out.println("entering dao"); BankAccount bAcct
	 * =bRepo.findByBName(name);
	 * 
	 * return bAcct; }
	 */

	@Override
	public BankAccount fetchBybalandbid(double bal,int id) {
		BankAccount bBal =bRepo.findByBalanceAndBId(bal,id);
		return bBal;
	}

	@Override
	public BankAccount fetbybnameanduid(String bname, int id) {
		BankAccount bacc =bRepo.findByBnameAndUserReg(bname,id);
		return bacc;
	}
	
	

}
