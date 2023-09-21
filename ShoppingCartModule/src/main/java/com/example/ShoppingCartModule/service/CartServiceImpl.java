package com.example.ShoppingCartModule.service;

import org.springframework.stereotype.Service;
import com.example.ShoppingCartModule.repository.*;
import com.example.ShoppingCartModule.entity.*;
import com.example.ShoppingCartModule.exception.ProductException;
import com.example.ShoppingCartModule.request.AddItemRequest;

@Service
public class CartServiceImpl implements CartService{
	
	private CartRepository cartRepository;
	private CartItemService cartItemService;
	private ProductService productService;

	public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService,ProductService productService) {
		this.cartRepository = cartRepository;
		this.cartItemService = cartItemService;
		this.productService = productService;
	}

	@Override
	public Cart createCart(User user) {
		Cart cart=new Cart();
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
		Cart cart=cartRepository.findByUserId(userId);
		Product product=productService.getProductById(req.getProductId());
		CartItem isPresent=cartItemService.isCartItemExist(cart, product,userId);
		if(isPresent==null) {
			CartItem cartItem=new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(req.getQunatity());
			cartItem.setUserId(userId);
			
			double price=req.getQunatity()*product.getDiscountPrice();
			cartItem.setPrice(price);
			CartItem createdCartItem=cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createdCartItem);
		}
		return "Item Added To Cart";
	}

	@Override
	public Cart findUserCart(Long userId) {
		Cart cart=cartRepository.findByUserId(userId);
		
		double totalPrice=0;
		double totalDiscountedPrice=0;
		int totalItem=0;
		//Suppose 3 items
		//1=>100 
		//2=>200
		//3=>100
		//so we need to update accordingly
		for(CartItem cartItem: cart.getCartItems()) {
			totalPrice=totalPrice+cartItem.getPrice();
			totalDiscountedPrice=totalDiscountedPrice+cartItem.getDiscountedPrice();
			totalItem=totalItem+cartItem.getQuantity();			
		}
		cart.setTotalDiscountPrice(totalItem);
		cart.setTotalItem(totalItem);
		cart.setTotalPrice(totalPrice);
		cart.setDiscount(totalPrice-totalDiscountedPrice);
		return cartRepository.save(cart);
	}
	

}
