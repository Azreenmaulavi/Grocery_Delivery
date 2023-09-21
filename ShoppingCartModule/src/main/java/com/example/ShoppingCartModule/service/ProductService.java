package com.example.ShoppingCartModule.service;
//The all services provide to Spring Boot controller class
//Calling all methods from EmployeeServiceImple.java (class) file
//EmployeeService.java

import java.util.List;

import com.example.ShoppingCartModule.entity.*;

public interface  ProductService {
	 Product saveProduct(Product product);
    List<Product> fetchAllProduct();
    Product getProductById(Long id);
    Product updateProductById(Integer id,  Product product);
    String deleteProductById(Integer id);
	
}