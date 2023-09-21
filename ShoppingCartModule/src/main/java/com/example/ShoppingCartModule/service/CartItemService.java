package com.example.ShoppingCartModule.service;

import com.example.ShoppingCartModule.entity.*;
import com.example.ShoppingCartModule.exception.CartItemException;
import com.example.ShoppingCartModule.exception.UserException;

public interface CartItemService {
	public CartItem createCartItem(CartItem cartItem);
	public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws CartItemException,UserException, Exception;
	public CartItem isCartItemExist(Cart cart,Product product,Long userId);
	public void removeCartItem(Long userId,Long cartItemId)throws CartItemException,UserException;
	public CartItem findCartItemById(long cartItemId)throws CartItemException;

}
