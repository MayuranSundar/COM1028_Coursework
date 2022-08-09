package com.com1028.sm02363;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Requirement2 extends BaseQuery{
			public Requirement2(String user, String pass) {
				super(user, pass);
			}

//	Requirement 2 - Report the account representative for each customer. (Where contact name is customer representative)
//			Method to get the values from customers table and store it in a Customers object			
			public List<Customers> getCustomers() {
				  ArrayList<Customers> cmrs = new ArrayList<Customers>();
				  try {
				    ResultSet results = useTable("customers");
				    while (results.next()) {
				      int customerNumber = results.getInt("customerNumber");
				      String customerName = results.getString("customerName");
				      String contactLastName = results.getString("contactLastName");
				      String contactFirstName = results.getString("contactFirstName");
				      String phone = results.getString("phone");
				      String addressLine1 = results.getString("addressLine1");
				      String addressLine2 = results.getString("addressLine2");
				      String city = results.getString("city");
				      String state = results.getString("state");
				      String postalCode = results.getString("postalCode");
				      String country = results.getString("country");
				      int salesRepEmployeeNumber = results.getInt("salesRepEmployeeNumber");
				      double creditLimit = results.getDouble("creditLimit");
				      cmrs.add(new Customers(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber,creditLimit ));
				    }

				  } catch (SQLException e) {					
						System.out.println("SQLException while fetching records");
						throw new RuntimeException(e);
					}
				  return cmrs;
				}

//			Method to print requirement 2
			public String printRequirement2() {
				List<Customers> cmrs = getCustomers();
				Iterator<Customers> iter = cmrs.iterator();
				Customers tmpCustomers;
				String str = "";
				String title = "Account Representative For All Customers And The Customers' Details.\n";
				
				while (iter.hasNext()) {
					tmpCustomers = iter.next();

					 str += "\n" + "Customer: " + tmpCustomers.getcustomerName() 
							+ "\n" + "Account Representative: " + tmpCustomers.getcontactFirstName() + " " + tmpCustomers.getcontactLastName()
							+ "\n" + "Phone Number: " + tmpCustomers.getphone() 
							+ "\n" + "Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate()
							+ "\n" + "PostalCode: " + tmpCustomers.getpostalCode()
							+ "\n" + "Country: " + tmpCustomers.getcountry() + "\n";
					}
//					System.out.println("Customer Name: " + tmpCustomers.getcustomerName());
//					System.out.println("Account Representative: " + tmpCustomers.getcontactFirstName() + " " + tmpCustomers.getcontactLastName());
//					System.out.println("Phone Number: " + tmpCustomers.getphone());
//					if(tmpCustomers.getaddressLine2() == null && tmpCustomers.getstate() == null ){
//						System.out.println("Address: " + tmpCustomers.getaddressLine1() + tmpCustomers.getcity());
//					} else if (tmpCustomers.getaddressLine2() == null) {
//						System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate());
//					} else if (tmpCustomers.getstate() == null){
//						System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity());
//					} else {
//						System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate());
//					}
////					System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate());
//					System.out.println("PostalCode: " + tmpCustomers.getpostalCode());
//					System.out.println("Country: " + tmpCustomers.getcountry() + "\n");
////					System.out.println("creditLimit : " + tmpCustomers.getcreditLimit() + "\n");
				
				return title + str;
			}
			
//			Requirement 2 - Report the account representative for each customer. (Where employee name is customer representative)
//			Method to get the values from employees table and store it in a Employees object
			public List<Employees> getEmployees() {
				  ArrayList<Employees> employees = new ArrayList<Employees>();
				  try {
				    ResultSet results = useTable("employees");
				    while (results.next()) {
				      int employeeNumber = results.getInt("employeeNumber");
				      String lastName = results.getString("lastName");
				      String firstName = results.getString("firstName");
				      String extension = results.getString("extension");
				      int reportsTo = results.getInt("reportsTo");
				      String email = results.getString("email");
				      String jobTitle = results.getString("jobTitle");
				      String officeCode = results.getString("officeCode");
				      employees.add(new Employees(employeeNumber, lastName, firstName, extension, email, reportsTo, jobTitle, officeCode));
				    }

				  } catch (SQLException e) {					
						System.out.println("SQLException while fetching records");
						throw new RuntimeException(e);
					}
				  return employees;
				}

//			Method to print requirement 2
			public String printReq2(){
				List<Customers> customers = getCustomers();
				List<Employees> employees= getEmployees();
				String str = "";
				String title = "Account Representative For All Customers And The Customers' Details.\n";
				
				for(Employees e : employees) {
					for(Customers c : customers) {
						
						if(c.getsalesRepEmployeeNumber() == e.getemployeeNumber()){
							
							str += "\n" + "Customer: " + c.getcustomerName() 
									+ "\nCustomer Name: " + c.getcontactFirstName() + " " + c.getcontactLastName()
									+ "\nAccount Representative: " + e.getfirstName() + " " + e.getlastName()
									+ "\nCustomer Phone Number: " + c.getphone() 
									+ "\nCustomer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity() + ", " + c.getstate()
									+ "\nCustomer PostalCode: " + c.getpostalCode()
									+ "\nCustomer Country: " + c.getcountry() + "\n";
					} 
							
//								System.out.println("Customer: " + c.getcustomerName());
//								System.out.println("Customer Name: " + c.getcontactFirstName() + " " + c.getcontactLastName());
//								System.out.println("Account Representative: " + e.getfirstName() + " " + e.getlastName());
//								System.out.println("Customer Phone Number: " + c.getphone());
//								if(c.getaddressLine2() == null && c.getstate() == null ){
//									System.out.println("Customer Address: " + c.getaddressLine1() + c.getcity());
//								} else if (c.getaddressLine2() == null) {
//									System.out.println("Customer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity() + ", " + c.getstate());
//								} else if (c.getstate() == null){
//									System.out.println("Customer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity());
//								} else {
//									System.out.println("Customer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity() + ", " + c.getstate());
//								}
//								System.out.println("Customer PostalCode: " + c.getpostalCode());
//								System.out.println("Customer Country: " + c.getcountry() + "\n");
						}
					}
				return title + str;
			}			
}