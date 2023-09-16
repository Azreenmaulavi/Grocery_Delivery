package com.example.crud.service;
import com.example.crud.entity.*;
import com.example.crud.repository.OrderDetailsRepository;
import com.example.crud.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderDetailsServiceImpl {
	private static String ORDER_PLACED="Placed";
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private ProductRepository productRepository;
	public void placeOrder(OrderInput orderInput) {
		List<OrderProductQuantity> productQuantityList=orderInput.getOrderProductQuantityList();
		
		for(OrderProductQuantity o: productQuantityList) {
			Product product=((Object) productRepository.findById(o.getProductId())).get();
			
			OrderDetails orderDetail=new OrderDetails(orderInput.getFullName(),orderInput.getFullAddress(),orderInput.getContactNumber(),orderInput.getAlternateContact(),
					ORDER_PLACED, OrderDetails.orderAmount:100.09,product,);
		}
		
	}

}

