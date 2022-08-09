package com.com1028.sm02363;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

import org.junit.Test;

public class Requirement3Test {
	private Statement statement;
	Requirement3 req = new Requirement3("root", "*Sm02363");
	
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
			String testTitle = "Reports of products that have been sold with a markup of 100% or more.\n";
			
			rs = stmt.executeQuery("SELECT p.productCode, p.productName, p.productLine, o.orderNumber, p.buyPrice, p.MSRP, o.priceEach FROM products P INNER JOIN orderdetails O ON P.productCode = O.productCode WHERE priceEach >= (p.buyPrice*2) ORDER by p.productCode ASC;");
			
			while (rs.next()) {
//				Getting data from table and storing it
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				String productLine = rs.getString("productLine");
				int orderNumber = rs.getInt("orderNumber");
				double buyPrice = rs.getDouble("buyPrice");
				double msrp = rs.getDouble("msrp");
				double priceEach = rs.getDouble("priceEach");

//				Saving all the string in one variable called testString
                testString += "\nProduct Code: " + productCode
                			+ "\nProduct Name: " + productName
                			+ "\nProduct Line: " + productLine
                			+ "\nOrder Number: " + orderNumber
                			+ "\nBuy Price: " + buyPrice
                			+ "\nMSRP: " + msrp
                			+ "\nPrice Each: " + priceEach + "\n";
        }
		assertEquals(req.printRequirement3(), testTitle + testString);
		
		}catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
