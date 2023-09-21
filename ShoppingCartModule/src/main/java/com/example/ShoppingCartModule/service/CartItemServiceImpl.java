package com.example.ShoppingCartModule.service;

import org.springframework.stereotype.Service;
import java.util.Optional;

import com.example.ShoppingCartModule.entity.*;
import com.example.ShoppingCartModule.exception.CartItemException;
import com.example.ShoppingCartModule.exception.UserException;
import com.example.ShoppingCartModule.repository.*;


@Service
public class CartItemServiceImpl implements CartItemService{
	private CartItemRepository cartItemRepository;
	private CartRepository cartRepository;
	private UserService userService;

	public CartItemServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository,UserService userService) {
		this.cartItemRepository = cartItemRepository;
		this.cartRepository = cartRepository;
		this.userService=userService;
	}

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountPrice()*cartItem.getQuantity());
		
		CartItem createdCartItem=cartItemRepository.save(cartItem);
		return createdCartItem;
		
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws Exception {
		CartItem item=findCartItemById(id);
		User user=userService.findUserById(item.getUserId());
		//5*200=1000
		if(user.getUserId().equals(userId)) {
			item.setQuantity(cartItem.getQuantity());
			item.setPrice(item.getQuantity()*item.getProduct().getPrice());
			item.setDiscountedPrice(item.getProduct().getDiscountPrice()*item.getQuantity());
		}
		
		return cartItemRepository.save(item);
		
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, Long userId) {
		CartItem cartItem=cartItemRepository.isCartItemExist(cart, product, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		CartItem cartItem= findCartItemById(cartItemId);
		
		User user=userService.findUserById(cartItem.getUserId());
		
		User reqUser=userService.findUserById(userId);
		if(user.getUserId().equals(reqUser.getUserId())){
			cartItemRepository.deleteById(cartItemId);
		}
		else {
			throw new UserException("You can't remove other user's item");
		}
		
		
	}
	@Override
	public CartItem findCartItemById(long cartItemId) throws CartItemException {
		Optional<CartItem> opt=cartItemRepository.findById(cartItemId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CartItemException("Cart Item not found with id"+cartItemId);
	}
	

}
