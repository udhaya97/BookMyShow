package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BankAccountDao;
import com.model.BankAccount;
@Service
@Transactional
public class BankAccountService implements BankServiceIntf {

	@Autowired
	BankAccountDao bDao;
	@Override
	public void save(BankAccount bAccount) {
		bDao.save(bAccount);

	}

	@Override
	public List<BankAccount> fetAll() {
		List<BankAccount> bAcct = bDao.fethAll();
		return bAcct;
	}

	@Override
	public List<BankAccount> fetbyUserReg(int id) {
		List<BankAccount> bact =bDao.fetbyUserReg(id);
		return bact;
	}

	/*
	 * @Override public BankAccount fetchByBname(String name) { BankAccount bac
	 * =bDao.fetchBybName(name); System.out.println("entering service"); return bac;
	 * }
	 */

	@Override
	public BankAccount fetchBybalandbid(double bal,int id) {
		BankAccount bBal =bDao.fetchBybalandbid(bal,id);
		return bBal;
	}

	@Override
	public BankAccount fetbybnameanduid(String bname, int id) {
		BankAccount bacc =bDao.fetbybnameanduid(bname, id);
		return bacc;
	}

}
