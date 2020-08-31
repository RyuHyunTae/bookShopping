package com.shopping.biz.user;

public class CreditcardVO {
	int creditcardNum;
	int license;
	String creditcardKind;
	String id;
	public int getCreditcardNum() {
		return creditcardNum;
	}
	public void setCreditcardNum(int creditcardNum) {
		this.creditcardNum = creditcardNum;
	}
	public int getLicense() {
		return license;
	}
	public void setLicense(int license) {
		this.license = license;
	}
	public String getCreditcardKind() {
		return creditcardKind;
	}
	public void setCreditcardKind(String creditcardKind) {
		this.creditcardKind = creditcardKind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CreditcardVO [creditcardNum=" + creditcardNum + ", license=" + license + ", creditcardKind="
				+ creditcardKind + ", id=" + id + "]";
	}
	
	
}
