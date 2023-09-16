package com.example.crud.service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.crud.repository.*;
import com.example.crud.entity.*;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
 private OrderRepository orderDao;
 
 public OrderServiceImpl(OrderRepository orderDao) {
   this.orderDao = orderDao;
 }

 @Override
 public @NotNull Iterable<Order> getAllOrders() {
   return this.orderDao.findAll();
 }

 @Override
 public Order create(@NotNull(message = "The order cannot be null.") @Valid Order order) {
   return this.orderDao.save(order);
 }

 @Override
 public void update(@NotNull(message = "The order cannot be null.") @Valid Order order) {
   this.orderDao.save(order);		
 }

}
