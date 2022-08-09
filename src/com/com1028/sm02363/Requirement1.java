package com.com1028.sm02363;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Requirement1 extends BaseQuery{
			public Requirement1(String user, String pass) {
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
			public String printRequirement1(){
				List<ProductLines> list = getProductLines();
				Iterator<ProductLines> iter = list.iterator();
				ProductLines tmpProducts;
				String str = "";
				String title = "List of the product lines that contain 'Cars'.\n";
				
				while (iter.hasNext()) {
					tmpProducts = iter.next();
					
					if (tmpProducts.getproductLine().contains("Car")) {
//						s = s + "\n" + tmpProducts.getproductLine() + "\n" + tmpProducts.gettextDescription();
						if(str.equals("")) {
		                	str += "Product Line: " + tmpProducts.getproductLine()+ "\nDescription: " +tmpProducts.gettextDescription() + "\n";
		                }else {
		                	str += "\nProduct Line: " + tmpProducts.getproductLine()+ "\nDescription: " +tmpProducts.gettextDescription() + "\n";
		                }
					}
				}
				return title + str;
			}
}
