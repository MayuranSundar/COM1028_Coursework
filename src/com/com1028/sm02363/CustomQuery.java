package com.com1028.sm02363;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomQuery extends BaseQuery{
		public CustomQuery(String user, String pass) {
			super(user, pass);
		}
		
		public void customerQuery(){			
			ArrayList<String> pList = new ArrayList<String>();
			try {
				ResultSet result = useTable("productlines");
				while (result.next()) {
					pList.add(result.getString("productLine"));
						       
//				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Iterator <String> iterator = pList.iterator();
			 while (iterator.hasNext()) {
		            String next = iterator.next();
		            if (next.contains("Cars")) {
		                System.out.println(next);
		}
		
//		while(result.next()) {
//			  hotelResult.add(result.getString("Enter the columnname here");
//			}
//	
		
		
			 }}	
		
}