package com.example.ShoppingCartModule.service;
import com.example.ShoppingCartModule.entity.*;
import com.example.ShoppingCartModule.exception.*;
import java.util.*;;
public interface OrderService {
	public Order createOrder(User user,Address shippingAddress);
	
	public Order findOrderById(Long orderId)throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId)throws OrderException; //status changed by admin
	
	public Order confirmedOrder(Long orderId)throws OrderException; //admin
	
	public Order shippeddOrder(Long orderId)throws OrderException; //admin
	
	public Order deliveredOrder(Long orderId)throws OrderException; //admin
	
	public Order canceledOrder(Long orderId)throws OrderException; //user and admin
	
	public List<Order>getAllOrders();  //admin
	 
	public void deleteOrder(Long orderId)throws OrderException;  //admin
	
	
}
