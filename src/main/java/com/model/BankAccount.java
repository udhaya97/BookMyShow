package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table

public class BankAccount  {
	
	/**
	 * 
	 */
	/* private static final long serialVersionUID = 1L; */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	@NotNull
	@Size(min=2,message="enter 2 to 10 character")
	private String bName;
	@NotNull
	@Size(min=5,message="enter 5 to 10 character")
	private String branch;
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 */
	@NotNull
	@Min(10000)
	private int accId;
	@NotNull
	@Size(min=5,message="enter 5 character")
	private String accType;
	@NotNull
	@Min(0)
	private double balance;

	
	  @ManyToOne private UserReg userReg;
	  
	 
	public UserReg getUserReg() {
		return userReg;
	}
	public void setUserReg(UserReg userReg) {
		this.userReg = userReg;
	}

	/*
	 * public static long getSerialversionuid() { return serialVersionUID;
	 */
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(int bId, String bName, String branch, int accId, String accType, double balance) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.branch = branch;
		this.accId = accId;
		this.accType = accType;
		this.balance = balance;
	}
	public BankAccount() {
		super();
	}
	
	

}
