package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productID;
	private String productName;
	private float productPrice;
	private String size;
	private String category;
	private boolean status;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productID, String productName, float productPrice, String size, String category,
			boolean status) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.size = size;
		this.category = category;
		this.status = status;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", size=" + size + ", category=" + category + ", status=" + status + "]";
	}	
	
	
	
	
	
	

}
