package com.com1028.sm02363;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

import org.junit.Test;

public class Requirement2Test {
	private Statement statement;
	Requirement2 req = new Requirement2("root", "*Sm02363");
	
	public static Connection getConnection() throws Exception{
		  
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";	   
			String password = "*Sm02363";  
			Class.forName(driver);
	 		Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
		} 
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	@Test
	public void testPrintRequirement2() throws SQLException {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","*Sm02363");
			Statement stmt = conn.createStatement();
			ResultSet rs;
			String testString = "";
			String testTitle = "Account Representative For All Customers And The Customers' Details.\n";
			
			rs = stmt.executeQuery("SELECT customerName, contactFirstName, contactLastName, phone, addressLine1, addressLine2, city, state, postalCode, country FROM customers;");
			
			while (rs.next()) {
//				Getting data from table and storing it
			    String customerName = rs.getString("customerName");
			    String contactLastName = rs.getString("contactLastName");
			    String contactFirstName = rs.getString("contactFirstName");
			    String phone = rs.getString("phone");
			    String addressLine1 = rs.getString("addressLine1");
			    String addressLine2 = rs.getString("addressLine2");
			    String city = rs.getString("city");
			    String state = rs.getString("state");
			    String postalCode = rs.getString("postalCode");
			    String country = rs.getString("country");

//				Saving all the string in one variable called testString
                testString += "\nCustomer: " + customerName 
                			+ "\nAccount Representative: " + contactFirstName + " " + contactLastName
            				+ "\nPhone Number: " + phone
            				+ "\nAddress: " + addressLine1 + ", " + addressLine2 + ", " + city + ", " + state
            				+ "\nPostalCode: " + postalCode
            				+ "\nCountry: " + country + "\n";
        }
		assertEquals(req.printRequirement2(), testTitle + testString);
	
		}catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrintReq2() throws SQLException {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","*Sm02363");
			Statement stmt = conn.createStatement();
			ResultSet rs;
			String testString = "";
			String testTitle = "Account Representative For All Customers And The Customers' Details.\n";
			
			rs = stmt.executeQuery("SELECT c.customerName, c.contactFirstName, c.contactLastName, c.phone, e.firstName, e.lastName, c.phone, c.addressLine1, c.addressLine2, c.city, c.state, c.postalCode, c.country FROM customers c INNER JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber;");
			
			while (rs.next()) {
//				Getting data from table and storing it
			    String customerName = rs.getString("customerName");
			    String contactLastName = rs.getString("contactLastName");
			    String contactFirstName = rs.getString("contactFirstName");
			    String firstName = rs.getString("firstName");
			    String lastName = rs.getString("lastName");
			    String phone = rs.getString("phone");
			    String addressLine1 = rs.getString("addressLine1");
			    String addressLine2 = rs.getString("addressLine2");
			    String city = rs.getString("city");
			    String state = rs.getString("state");
			    String postalCode = rs.getString("postalCode");
			    String country = rs.getString("country");

//				Saving all the string in one variable called testString
                testString += "\nCustomer: " + customerName 
                			+ "\nCustomer Name: " + contactFirstName + " " + contactLastName
                			+ "\nAccount Representative: " + firstName + " " + lastName
                			+ "\nCustomer Phone Number: " + phone
            				+ "\nCustomer Address: " + addressLine1 + ", " + addressLine2 + ", " + city + ", " + state
            				+ "\nCustomer PostalCode: " + postalCode
            				+ "\nCustomer Country: " + country + "\n";
        }
		assertEquals(req.printReq2(), testTitle + testString);
	
		}catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
