package com.com1028.sm02363;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Requirement3 extends BaseQuery{
			public Requirement3(String user, String pass) {
				super(user, pass);
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
			public String printRequirement3() {
				List<OrderDetails> orderDetails = getOrderDetails();
				List<Products> products = getProducts();
				String str = "";
				String title = "Reports of products that have been sold with a markup of 100% or more.\n";
				
				for(Products p : products) {
					for(OrderDetails o : orderDetails) {
											
						if(o.getproductCode().equalsIgnoreCase(p.getproductCode())) {
							 if(o.getpriceEach() >= (2*p.getbuyPrice())){
								str += "\nProduct Code: " + p.getproductCode() 
									+ "\nProduct Name: " + p.getproductName()
									+ "\nProduct Line: " + p.getproductLine()
									+ "\nOrder Number: " + o.getorderNumber()
									+ "\nBuy Price: " + p.getbuyPrice()
									+ "\nMSRP: " + p.getMSRP()
									+ "\nPrice Each: " + o.getpriceEach() + "\n";
								 
//								System.out.println("Product Code: " + p.getproductCode());
//								System.out.println("Product Name: " + p.getproductName());
//								System.out.println("Product Line: " + p.getproductLine());
//								System.out.println("Order Number: " + o.getorderNumber());
//								System.out.println("Buy Price: " + p.getbuyPrice());
//								System.out.println("MSRP: " + p.getMSRP());
//								System.out.println("Price Each: " + o.getpriceEach() + "\n");
							}
						}
					}
				}
				return title + str;
			}
}
