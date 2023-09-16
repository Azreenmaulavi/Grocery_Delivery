package com.example.crud.dto;
import java.math.BigInteger;
import lombok.Data;

@Data
public class OrderRequest {
	String customerName;
	String email;
	String phoneNumber;
	BigInteger amount;
	

	public OrderRequest(String customerName, String email, String phoneNumber, BigInteger amount) {
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}


}
