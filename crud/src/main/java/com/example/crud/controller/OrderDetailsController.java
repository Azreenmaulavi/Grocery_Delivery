package com.example.crud.controller;
import com.example.crud.entity.*;
import com.example.crud.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class OrderDetailsController {
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody OrderInput orderInput) {
		orderDetailsService.placeOrder(orderInput);
		
	}

}
