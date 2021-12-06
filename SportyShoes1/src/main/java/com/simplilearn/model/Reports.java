package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REPORTS")
public class Reports {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseID;
	private String date;
	private String category;
	private String productName;
	private float productPrice;
	private String customer;
	
	public Reports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reports(int purchaseID, String date, String category, String productName, float productPrice,
			String customer) {
		super();
		this.purchaseID = purchaseID;
		this.date = date;
		this.category = category;
		this.productName = productName;
		this.productPrice = productPrice;
		this.customer = customer;
	}

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Reports [purchaseID=" + purchaseID + ", date=" + date + ", category=" + category + ", productName="
				+ productName + ", productPrice=" + productPrice + ", customer=" + customer + "]";
	}

	
	

}
