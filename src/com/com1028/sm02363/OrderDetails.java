package com.com1028.sm02363;

public class OrderDetails {
	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private double priceEach;
	private short orderLineNumber;

	public OrderDetails(int orderNumber,String productCode,int quantityOrdered,double priceEach,short orderLineNumber) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}
	
	public int getorderNumber() {
		return this.orderNumber;
	}
	
	public String getproductCode() {
		return this.productCode;
	}
	
	public int getquantityOrdered() {
		return this.quantityOrdered;
	}
	
	public double getpriceEach() {
		return this.priceEach;
	}
	
	public short getorderLineNumber() {
		return this.orderLineNumber;
	}
}