package com.example.crud.controller;
//Controller file
//we only create the file(OrderSummaryController.java)
import com.example.crud.entity.OrderSummary;
import com.example.crud.service.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderSummaryController {

    @Autowired
    private OrderSummaryService OrderSummaryService;
    @PostMapping("/OrderSummary")
    public OrderSummary saveOrderSummary(@RequestBody OrderSummary OrderSummary) {
        return OrderSummaryService.saveOrderSummary(OrderSummary);
    }
    @GetMapping("/OrderSummary")
    public List<OrderSummary> getAllOrderSummarys() {
        return OrderSummaryService.fetchAllOrderSummarys();
    }
    @GetMapping("/OrderSummary/{id}")
    public OrderSummary getOrderSummaryById(@PathVariable("id") Long id) {
        return OrderSummaryService.getOrderSummaryById(id);
    }

    @PutMapping("/OrderSummary/{id}")
    public OrderSummary updateOrderSummary(@PathVariable("id") Long id, @RequestBody OrderSummary OrderSummary) {
        return OrderSummaryService.updateOrderSummaryById(id, OrderSummary);
    }
    @DeleteMapping("/OrderSummary/{id}")
    public String deleteOrderSummary(@PathVariable("id") Long id) {
        return OrderSummaryService.deleteDepartmentById(id);
    }
}
