package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;*/

import org.springframework.stereotype.Component;

@Component
@Entity
@Table


public class UserReg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	
	/*
	 * @NotNull(message="enter user name")
	 * 
	 * @Size(min=5,max=15,message="username length should be 5 to 15")
	 */
	 @NotNull
	 
	 @Size(min=2,message="enter user name")
	private String uName;
	
	
	  @NotNull
	  @Size(min=5,message="length should be 5 to 20")
	 
	 
	private String pass;
	  
	@NotNull
	@Size(min=4,message="Enter dob ")
	private String dob;
	//private String gender;
	
	
	  @NotNull(message="enter mail id")
	  
	  @Email
	  @Pattern(regexp=".+@.+\\..+", message="Enter The correct email")
	private String mailId;
	
	@NotNull
	@Size(min=10,max=10,message="Enter Mobile No")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNo;
	  
	  
	@NotNull
	@Size(min=4,max=6)
	private String role;
	
	  @OneToMany private List<BankAccount> bAccount;


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public List<BankAccount> getbAccount() {
		return bAccount;
	}


	public void setbAccount(List<BankAccount> bAccount) {
		this.bAccount = bAccount;
	}


	/*
	 * public UserReg(int uId, String uName, String pass, String dob, String mailId,
	 * long mobileNo) { super(); this.uId = uId; this.uName = uName; this.pass =
	 * pass; this.dob = dob; this.mailId = mailId; this.mobileNo = mobileNo; }
	 */


	


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	
	/*
	 * public String getGender() { return gender; }
	 * 
	 * 
	 * public void setGender(String gender) { this.gender = gender; }
	 */


	public UserReg() {
		super();
	}


	public UserReg(int uId, String uName, String pass, String dob,  String mailId, String mobileNo,
			String role) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.pass = pass;
		this.dob = dob;
		
		this.mailId = mailId;
		this.mobileNo = mobileNo;
		this.role = role;
	}
	
}
