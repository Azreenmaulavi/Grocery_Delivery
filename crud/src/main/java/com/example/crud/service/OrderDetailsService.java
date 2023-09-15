package com.example.crud.service;
import com.example.crud.entity.*;

public interface OrderDetailsService {
	public void placeOrder(OrderInput orderInput);
	OrderDetails findById(Integer id);

}
