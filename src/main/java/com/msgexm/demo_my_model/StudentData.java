package com.msgexm.demo_my_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "studentData")
public class StudentData {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sId")
	private Long  sId;
	@Column(name = "sNm")
	private String sNm;
	@Column(name = "sPassword")
	private String sPassword;
	@Column(name = "sEmail")
	private String sEmail;
	@Column(name = "sPhone")
	private String sPhone;
	@Column(name = "sZender")
	private String sZender;
	public StudentData() {
	super();
}
public StudentData(Long  sId, String sNm, String sEmail, String sPhone, String sZender,String sPassword) {
	super();
	this.sId = sId;
	this.sNm = sNm;
	this.sEmail = sEmail;
	this.sPhone = sPhone;
	this.sZender = sZender;
	this.sPassword=sPassword;
}



public Long  getsId() {
	return sId;
}
public void setsId(Long  sId) {
	this.sId = sId;
}
public String getsPassword() {
	return sPassword;
}
public void setsPassword(String sPassword) {
	this.sPassword = sPassword;
}
public String getsNm() {
	return sNm;
}
public void setsNm(String sNm) {
	this.sNm = sNm;
}
public String getsEmail() {
	return sEmail;
}
public void setsEmail(String sEmail) {
	this.sEmail = sEmail;
}
public String getsPhone() {
	return sPhone;
}
public void setsPhone(String sPhone) {
	this.sPhone = sPhone;
}
public String getsZender() {
	return sZender;
}
public void setsZender(String sZender) {
	this.sZender = sZender;
}

}
