package com.com1028.sm02363;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

public class Requirement1Test {
	private Statement statement;
	Requirement1 req = new Requirement1("root", "*Sm02363");
	
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
	public void testPrintRequirement1() throws SQLException {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","*Sm02363");
			Statement stmt = conn.createStatement();
			ResultSet rs;
			String testString = "";
			String testTitle = "List of the product lines that contain 'Cars'.\n";
			
			rs = stmt.executeQuery("SELECT productLine, textDescription FROM productlines WHERE productLine LIKE '%Car%';");
			
			
			while ( rs.next() ) { 
//				Getting data from table and storing it
				String productLine = rs.getString("productLine");
				String textDescription = rs.getString("textDescription");
				
//				Saving all the string in one variable called testString
				if(testString.equals("")) {
                	testString += "Product Line: " + productLine+ "\nDescription: " +textDescription + "\n";
                }else {
                	testString += "\nProduct Line: " + productLine+ "\nDescription: " +textDescription + "\n";
                }
        }
		assertEquals(req.printRequirement1(), testTitle + testString);
		
		}catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
