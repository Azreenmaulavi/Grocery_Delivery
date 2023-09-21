package com.example.ShoppingCartModule.service;

import com.example.ShoppingCartModule.entity.Cart;
import com.example.ShoppingCartModule.entity.User;
import com.example.ShoppingCartModule.exception.ProductException;
import com.example.ShoppingCartModule.request.AddItemRequest;

public interface CartService {
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req)throws ProductException;
	
	public Cart findUserCart(Long userId);
	

}
