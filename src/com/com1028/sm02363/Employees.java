package com.com1028.sm02363;

public class Employees
{
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private int reportsTo;
	private String email;
	private String jobTitle;
	private String officeCode;
	
	public Employees(int employeeNumber,String lastName,String firstName,String extension,String email,int reportsTo,String jobTitle,String officeCode) {
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
		this.officeCode = officeCode;
	}
	
	public int getemployeeNumber() {
		return this.employeeNumber;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public String getextension() {
		return this.extension;
	}

	public String getemail() {
		return this.email;
	}

	public int getreportsTo() {
		return this.reportsTo;
	}

	public String getjobTitle() {
		return this.jobTitle;
	}

	public String getofficeCode() {
		return this.officeCode;
	}

}
