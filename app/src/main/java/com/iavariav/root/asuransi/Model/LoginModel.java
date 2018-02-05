package com.iavariav.root.asuransi.Model;

import com.google.gson.annotations.SerializedName;

public class LoginModel{

	@SerializedName("nama")
	private String nama;

	@SerializedName("ktp")
	private String ktp;

	@SerializedName("rule_login")
	private String ruleLogin;

	@SerializedName("status_user")
	private String statusUser;

	@SerializedName("fullname")
	private String fullname;

	@SerializedName("error")
	private boolean error;

	@SerializedName("email")
	private String email;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setKtp(String ktp){
		this.ktp = ktp;
	}

	public String getKtp(){
		return ktp;
	}

	public void setRuleLogin(String ruleLogin){
		this.ruleLogin = ruleLogin;
	}

	public String getRuleLogin(){
		return ruleLogin;
	}

	public void setStatusUser(String statusUser){
		this.statusUser = statusUser;
	}

	public String getStatusUser(){
		return statusUser;
	}

	public void setFullname(String fullname){
		this.fullname = fullname;
	}

	public String getFullname(){
		return fullname;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}