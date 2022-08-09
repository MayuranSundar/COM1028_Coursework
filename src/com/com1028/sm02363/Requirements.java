package com.com1028.sm02363;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Requirements extends BaseQuery{
			public Requirements(String user, String pass) {
				super(user, pass);
			}
			// Requirement 1 - List the product lines that contain 'Cars'
//			Method to get the values from productlines table and store it in a ProductLines object
			public List<ProductLines> getProductLines(){			
				ArrayList<ProductLines> products = new ArrayList<ProductLines>();
				try {
					ResultSet results = useTable("productlines");
					while (results.next()) {		
						String name = results.getString("productLine");
						String des = results.getString("textDescription");
						products.add(new ProductLines(name, des));
					}
				} catch (SQLException e) {					
					System.out.println("SQLException while fetching records");
					throw new RuntimeException(e);
				}
				return products;
				
			}
//			Method to print requirement 1
			public void printRequirement1(){
				List<ProductLines> list = getProductLines();
				Iterator<ProductLines> iter = list.iterator();
				ProductLines tmpProducts;
				System.out.println("Product lines that contain 'Cars'.\n" );
				while (iter.hasNext()) {
					tmpProducts = iter.next();
					
					if (tmpProducts.getproductLine().contains("Car")) {
						System.out.println("Product Line: " + tmpProducts.getproductLine());
						System.out.println("Product Description: " + tmpProducts.gettextDescription() + "\n");
					}
				}
			}
			
//			Requirement 2 - Report the account representative for each customer. (Where contact name is customer representative)
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
			public void printRequirement2() {
				List<Customers> cmrs = getCustomers();
				Iterator<Customers> iter = cmrs.iterator();
				Customers tmpCustomers;
				
				System.out.println("Account Representative For All Customers And The Customers' Cetails.'\n" );
				
				while (iter.hasNext()) {
					tmpCustomers = iter.next();

					System.out.println("Customer Name: " + tmpCustomers.getcustomerName());
					System.out.println("Account Representative: " + tmpCustomers.getcontactFirstName() + " " + tmpCustomers.getcontactLastName());
					System.out.println("Phone Number: " + tmpCustomers.getphone());
					if(tmpCustomers.getaddressLine2() == null && tmpCustomers.getstate() == null ){
						System.out.println("Address: " + tmpCustomers.getaddressLine1() + tmpCustomers.getcity());
					} else if (tmpCustomers.getaddressLine2() == null) {
						System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate());
					} else if (tmpCustomers.getstate() == null){
						System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity());
					} else {
						System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate());
					}
//					System.out.println("Address: " + tmpCustomers.getaddressLine1() + ", " + tmpCustomers.getaddressLine2() + ", " + tmpCustomers.getcity() + ", " + tmpCustomers.getstate());
					System.out.println("PostalCode: " + tmpCustomers.getpostalCode());
					System.out.println("Country: " + tmpCustomers.getcountry() + "\n");
//					System.out.println("creditLimit : " + tmpCustomers.getcreditLimit() + "\n");
				}
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
			public void printReq2(){
				List<Customers> customers = getCustomers();
				List<Employees> employees= getEmployees();
			
				for(Customers c : customers) {
					for(Employees e : employees) {
						
						if(c.getsalesRepEmployeeNumber() == e.getemployeeNumber()){
							 
								System.out.println("Customer: " + c.getcustomerName());
								System.out.println("Customer Name: " + c.getcontactFirstName() + " " + c.getcontactLastName());
								System.out.println("Account Representative: " + e.getfirstName() + " " + e.getlastName());
								System.out.println("Customer Phone Number: " + c.getphone());
								if(c.getaddressLine2() == null && c.getstate() == null ){
									System.out.println("Customer Address: " + c.getaddressLine1() + c.getcity());
								} else if (c.getaddressLine2() == null) {
									System.out.println("Customer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity() + ", " + c.getstate());
								} else if (c.getstate() == null){
									System.out.println("Customer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity());
								} else {
									System.out.println("Customer Address: " + c.getaddressLine1() + ", " + c.getaddressLine2() + ", " + c.getcity() + ", " + c.getstate());
								}
								System.out.println("Customer PostalCode: " + c.getpostalCode());
								System.out.println("Customer Country: " + c.getcountry() + "\n");
						}
					}
				}
			}				
			
//			Requirement 3 - Reports those products that have been sold with a mark up of 100% or more.
//			Method to get the values from products table and store it in a Products object
			public List<Products> getProducts(){			
				ArrayList<Products> products = new ArrayList<Products>();
				try {
					ResultSet results = useTable("products");
					while (results.next()) {		
						String productCode = results.getString("productCode");
						String productName = results.getString("productName");
						String productScale = results.getString("productScale");
						String productVendor = results.getString("productVendor");
						String productDescription = results.getString("productDescription");
						short quantityInStock = results.getShort("quantityInStock");
						double buyPrice = results.getDouble("buyPrice");
						double msrp = results.getDouble("msrp");
						String productLine = results.getString("productLine");
						products.add(new Products(productCode, productName, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp, productLine));
					}
				} catch (SQLException e) {					
					System.out.println("SQLException while fetching records");
					throw new RuntimeException(e);
				}
				return products;
			}

//			Method to get the values from orderdetails table and store it in a OrderDetails object
			public List<OrderDetails> getOrderDetails(){			
				ArrayList<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
				try {
					ResultSet results = useTable("orderdetails");
					while (results.next()) {		
						int orderNumber = results.getInt("orderNumber");
						String productCode = results.getString("productCode");
						int quantityOrdered = results.getInt("quantityOrdered");
						double priceEach = results.getDouble("priceEach");
						short orderLineNumber = results.getShort("orderLineNumber");
						orderDetails.add(new OrderDetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber));
					}
				} catch (SQLException e) {					
					System.out.println("SQLException while fetching records");
					throw new RuntimeException(e);
				}
				return orderDetails;
			}

//			Method to print requirement 3
			public void printRequirement3() {
				List<OrderDetails> orderDetails = getOrderDetails();
				List<Products> products = getProducts();
			
				for(OrderDetails o : orderDetails) {
					for(Products p : products) {
						
						if(o.getproductCode().equalsIgnoreCase(p.getproductCode())) {
							 {
								System.out.println("Product Code: " + p.getproductCode());
								System.out.println("Product Name: " + p.getproductName());
								System.out.println("Product Line: " + p.getproductLine());
								System.out.println("Order Number: " + o.getorderNumber());
								System.out.println("Buy Price: " + p.getbuyPrice());
								System.out.println("MSRP: " + p.getMSRP());
								System.out.println("Price Each: " + o.getpriceEach() + "\n");
							}
						}
					}
				}
			}
}
