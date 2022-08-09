package com.com1028.sm02363;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) throws Exception {
		
		 try {
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","*Sm02363");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	            String testString = "";
	            rs = stmt.executeQuery("SELECT productLine, textDescription FROM productlines WHERE productLine LIKE '%Car%';");
	            while ( rs.next() ) {
	                String productLine = rs.getString("productLine");
	                String textDescription = rs.getString("textDescription");
	                if(testString.equals("")) {
	                	testString = testString + productLine+ "\n" +textDescription;
	                }else {
	                	testString = testString + "\n" + productLine+ "\n" +textDescription;
	                }
	            }
	            System.out.println(testString);
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }  
	}
	 
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
}

