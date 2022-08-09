package com.com1028.sm02363;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.com1028.sm02363.Customers;

public class CustomersDAOImpl implements CustomersDAO {
	
	private Connection connect;
	private Statement statement;

	public CustomersDAOImpl() {
		super();
		this.connect = null;
		this.statement = null;
		this.openConnection();
	}

	public void openConnection() {
		try {
			if (this.connect == null || this.connect.isClosed()) {
				this.connect = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "*Sm02363");
			}
			if (this.statement == null || this.statement.isClosed()) {
				this.statement = this.connect.createStatement();
			}

		} catch (SQLException e) {
			System.out
					.println("ERRRO - Failed to create a connection to the database");
			throw new RuntimeException(e);
		}
	}

	public void closeConnection() {

		try {

			if (this.statement != null) {
				this.statement.close();
			}
			if (this.connect != null) {
				this.connect.close();
			}
			System.out.println("Closed the connection to the database");
		} catch (Exception e) {
			System.out
					.print("ERROR-Failed to close the connection to the database");
			throw new RuntimeException(e);
		}
	}

	public List<Customers> getCustomers() {
		ArrayList<Customers> cmrs = new ArrayList<Customers>();
		try {
			String query = "SELECT * FROM Customers Limit 5";

			ResultSet results = this.statement.executeQuery(query);

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
//			Change the message
			System.out.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return cmrs;
	}

	public void showAllCustomers() {

		List<Customers> cmrs = getCustomers();
		Iterator<Customers> iter = cmrs.iterator();

		Customers tmpCustomers;
		while (iter.hasNext()) {
			tmpCustomers = iter.next();

			System.out.println("Customer Number: " + tmpCustomers.getcustomerNumber());
			System.out.println("Customer Name: " + tmpCustomers.getcustomerName());
			System.out.println("contactLastName: " + tmpCustomers.getcontactLastName());
			System.out.println("contactFirstName 13: " + tmpCustomers.getcontactFirstName());
			System.out.println("phone: " + tmpCustomers.getphone());
			System.out.println("addressLine1: " + tmpCustomers.getaddressLine1());
			System.out.println("addressLine2: " + tmpCustomers.getaddressLine2());
			System.out.println("city: " + tmpCustomers.getcity());
			System.out.println("state: " + tmpCustomers.getstate());
			System.out.println("postalCode: " + tmpCustomers.getpostalCode());
			System.out.println("country: " + tmpCustomers.getcountry());
			System.out.println("salesRepEmployeeNumber: " + tmpCustomers.getsalesRepEmployeeNumber());
			System.out.println("creditLimit : " + tmpCustomers.getcreditLimit() + "\n");
		}
	}

}
