package com.shopping.biz.user;

public class AddressVO {
	int addressNum;
	String address;
	String addressdetail;
	String id;
	int postCode;
	public int getAddressNum() {
		return addressNum;
	}
	public void setAddressNum(int addressNum) {
		this.addressNum = addressNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressdetail() {
		return addressdetail;
	}
	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "AddressVO [addressNum=" + addressNum + ", address=" + address + ", addressdetail=" + addressdetail
				+ ", id=" + id + ", postCode=" + postCode + "]";
	}
	
	
}
