package com.com1028.sm02363;

public class ProductLines {
	private String productLine;
	private String textDescription;
//	public String htmlDescription;
//	Find out the right type
//	public String image;

//	public ProductLines(String productLine,String textDescription,String htmlDescription,String image) {
//		this.productLine = productLine;
//		this.textDescription = textDescription;
//		this.htmlDescription = htmlDescription;
//		this.image = image;
//	}
	
	public ProductLines(String productLine,String textDescription){
		this.productLine = productLine;
		this.textDescription = textDescription;	
	}
	
	public String getproductLine() {
		return this.productLine;
	}
	public String gettextDescription() {
		return this.textDescription;
	}
//	public String gethtmlDescription() {
//		return this.htmlDescription;
//	}
//	Find out the right type
//	public String getimage() {
//		return this.image;
//	}
}
