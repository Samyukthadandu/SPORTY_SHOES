package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cID;
	private String cName;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cID, String cName) {
		super();
		this.cID = cID;
		this.cName = cName;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "Customer [cID=" + cID + ", cName=" + cName + "]";
	}
	
	
	
	
	
	

}
