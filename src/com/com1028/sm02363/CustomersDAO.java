package com.com1028.sm02363;

import java.util.List;
import com.com1028.sm02363.Customers;

public interface CustomersDAO {
	public void openConnection();

	public void closeConnection();
	
	public List<Customers> getCustomers();
	
	public void showAllCustomers();
}
