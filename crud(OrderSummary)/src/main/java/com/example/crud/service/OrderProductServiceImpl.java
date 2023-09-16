package com.example.crud.service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.crud.repository.*;
import com.example.crud.entity.*;

@Transactional
@Component
public class OrderProductServiceImpl implements OrderProductService {
	
 @Autowired
 private OrderProductRepository orderProductDao;

 @Override
 public OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
   return this.orderProductDao.save(orderProduct);
 }
}

