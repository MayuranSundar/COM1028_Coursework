package com.com1028.sm02363;

public class Customers {
	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private double creditLimit;

	public Customers(int customerNumber,String customerName,String contactLastName,String contactFirstName,String phone,String addressLine1,String addressLine2,String city,String state,String postalCode,String country,int salesRepEmployeeNumber,double creditLimit) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}
	
	public int getcustomerNumber() {
		return this.customerNumber;
	}
	
	public String getcustomerName() {
		return this.customerName;
	}
	
	public String getcontactLastName() {
		return this.contactLastName;
	}
	public String getcontactFirstName() {
		return this.contactFirstName;
	}
	
	public String getphone() {
		return this.phone;
	}
	
	public String getaddressLine1() {
		return this.addressLine1;
	}
	
	public String getaddressLine2() {
		return this.addressLine2;
	}
	
	public String getcity() {
		return this.city;
	}
	
	public String getstate() {
		return this.state;
	}
	
	public String getpostalCode() {
		return this.postalCode;
	}
	
	public String getcountry() {
		return this.country;
	}
	
	public int getsalesRepEmployeeNumber() {
		return this.salesRepEmployeeNumber;
	}
	
	public double getcreditLimit() {
		return this.creditLimit;
	}
	
}
