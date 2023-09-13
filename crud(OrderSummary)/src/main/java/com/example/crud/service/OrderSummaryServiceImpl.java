package com.example.crud.service;
//All business logic(services) we are going to achieve with predefined methods(save(),findAll()....
//OrderSummaryServiceImple.java
import com.example.crud.entity.OrderSummary;
import com.example.crud.repository.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderSummaryServiceImpl implements OrderSummaryService{

    @Autowired
    private OrderSummaryRepository OrderSummaryRepository;

    @Override
    public OrderSummary saveOrderSummary(OrderSummary orderSummary) {//saving records
        return OrderSummaryRepository.save(orderSummary);
    }

    @Override
    public List<OrderSummary> fetchAllOrderSummarys() {
        List<OrderSummary> allOrderSummarys = OrderSummaryRepository.findAll();//select the records from db table
        return allOrderSummarys;
    }

    @Override
    public OrderSummary getOrderSummaryById(Long id) {
        Optional<OrderSummary> orderSummary = OrderSummaryRepository.findById(id);//get the values based on customer requirement
        if (orderSummary.isPresent()) {
            return orderSummary.get();
        }
        return null;
    }
    @Override
    public OrderSummary updateOrderSummaryById(Long id, OrderSummary orderSummary) {//based on selected id we are going to edit(Update) the record here
        Optional<OrderSummary> OrderSummary1 = OrderSummaryRepository.findById(id);

        if (OrderSummary1.isPresent()) {
            OrderSummary originalOrderSummary = OrderSummary1.get();

            if (Objects.nonNull(orderSummary.getId()) && orderSummary.getId()!=0) {
                originalOrderSummary.setId(orderSummary.getId());
            }
            if (Objects.nonNull(orderSummary.getOrderNumber()) && !"".equalsIgnoreCase(orderSummary.getOrderNumber())) {
                originalOrderSummary.setOrderNumber(orderSummary.getOrderNumber());
            }
            if (Objects.nonNull(orderSummary.getAddress()) && !"".equalsIgnoreCase(orderSummary.getAddress())) {
                originalOrderSummary.setAddress(orderSummary.getAddress());
            }
            
            return OrderSummaryRepository.save(originalOrderSummary);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {//deleting the records from the mysql db table
        if (OrderSummaryRepository.findById(id).isPresent()) {
            OrderSummaryRepository.deleteById(id);
            return "OrderSummary deleted successfully";
        }
        return "No such OrderSummary in the database";//table not present unable to delete the record
    }
}
