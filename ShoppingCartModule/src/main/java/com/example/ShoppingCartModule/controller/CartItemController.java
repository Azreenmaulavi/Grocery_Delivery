package com.example.ShoppingCartModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCartModule.entity.*;
import com.example.ShoppingCartModule.exception.CartItemException;
import com.example.ShoppingCartModule.exception.UserException;
import com.example.ShoppingCartModule.service.*;

@RestController
@RequestMapping("/api/cart/items")
public class CartItemController {
	 @Autowired
	    private CartItemService cartItemService; // You need to inject your CartItemService here

	    @Autowired
	    private UserService userService; 
	    
	    @GetMapping("/user")
		public ResponseEntity <CartItem>getCartItems(@RequestHeader("Authorization")String jwt) throws UserException, CartItemException{
		
			User user=userService.findUserProfileByJwt(jwt);
			CartItem cartItem=cartItemService.findCartItemById(user.getUserId());
			return new ResponseEntity<>(cartItem,HttpStatus.CREATED);
			
		}
}
