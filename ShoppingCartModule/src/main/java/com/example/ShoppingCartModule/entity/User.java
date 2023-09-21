package com.example.ShoppingCartModule.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long UserId;
	private String UserName;
	private String email;
	private String password;
	
	@OneToOne(mappedBy="user")
	private Cart cart;
	
	public User(Long userId, String userName, String email, String password, Cart cart) {
		this.UserId = userId;
		this.UserName = userName;
		this.email = email;
		this.password = password;
		this.cart = cart;
	}

	public User() {

	}
	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	


}
