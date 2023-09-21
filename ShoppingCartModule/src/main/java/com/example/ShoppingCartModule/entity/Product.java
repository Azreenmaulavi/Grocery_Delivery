package com.example.ShoppingCartModule.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductId;
    private String name;
    private String description;
    private Double price;
    private Double DiscountPrice;
    private boolean stock=true;
    private int quantity;
	public Product(Long productId, String name, String description, Double price, Double Discountprice,boolean stock, int quantity) {
		this.ProductId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.DiscountPrice=Discountprice;
		this.stock = stock;
		this.quantity = quantity;
	}
	public Product(String name, String description, Double price,Double Discountprice,boolean stock, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.DiscountPrice=Discountprice;
		this.stock = stock;
		this.quantity = quantity;
	}
	public Product() {
		
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscountPrice() {
		return DiscountPrice;
	}
	public void setDiscountPrice(Double discountprice) {
		DiscountPrice = discountprice;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	}
    


