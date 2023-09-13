package com.example.crud.entity;
//Hibernate Persistence class
//OrderSummary.java file
//creating OrderSummary persistence class(table)
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String OrderNumber;
   // private int OrderSummaryage;
   // private String sclass;
    private String address;
    
    public OrderSummary(Long Id,String OrderNumber,String address)
    {
    	this.Id=Id;
    	this.OrderNumber=OrderNumber;
//    	this.OrderSummaryage=OrderSummaryage;
//    	this.sclass=sclass;
    	this.address=address;
    }
    public OrderSummary(String OrderNumber,String address)
    {
    	this.OrderNumber=OrderNumber;
    	this.address=address;
    }
    public OrderSummary() {
    	
    }
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
    
    
}
  