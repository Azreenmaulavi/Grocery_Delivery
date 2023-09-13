package com.example.crud.service;
//The all services provide to Spring Boot controller class
//Calling all methods from OrderSummaryServiceImple.java (class) file
//OrderSummaryService.java
import com.example.crud.entity.OrderSummary;

import java.util.List;

public interface OrderSummaryService {
    OrderSummary saveOrderSummary(OrderSummary OrderSummary);
    List<OrderSummary> fetchAllOrderSummarys();
    OrderSummary getOrderSummaryById(Long id);
    OrderSummary updateOrderSummaryById(Long id, OrderSummary OrderSummary);
    String deleteDepartmentById(Long id);
}
