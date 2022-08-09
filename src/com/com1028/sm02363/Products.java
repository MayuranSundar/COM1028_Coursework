package com.com1028.sm02363;

public class Products {
	private String productCode;
	private String productName;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private short quantityInStock;
	private double buyPrice;
	private double msrp;
	private String productLine;

	public Products(String productCode,String productName,String productScale,String productVendor,String productDescription,short quantityInStock,double buyPrice,double msrp,String productLine) 	{
		this.productCode = productCode;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
		this.productLine = productLine;
	}
	
	public String getproductCode() {
		return this.productCode;
	}
	
	public String getproductName() {
		return this.productName;
	}
	
	public String getproductScale() {
		return this.productScale;
	}
	
	public String getproductVendor() {
		return this.productVendor;
	}
	
	public String getproductDescription() {
		return this.productDescription;
	}
	
	public short getquantityInStock() {
		return this.quantityInStock;
	}
	
	public double getbuyPrice() {
		return this.buyPrice;
	}
	
	public double getMSRP() {
		return this.msrp;
	}
	
	public String getproductLine() {
		return this.productLine;
	}
}