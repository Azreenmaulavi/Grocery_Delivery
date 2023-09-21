package com.example.ShoppingCartModule.service;
import com.example.ShoppingCartModule.entity.*;
//All business logic(services) we are going to achieve with predefined methods(save(),findAll()....
//EmployeeServiceImple.java
import com.example.ShoppingCartModule.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {//saving records
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProduct() {
        Iterable<Product> allProduct = productRepository.findAll();//select the records from db table
        return (List<Product>) allProduct;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);//get the values based on customer requirement
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }
    @Override
    public Product updateProductById(Integer id, Product product) {//based on selected id we are going to edit(Update) the record here
        Optional<Product> product1 = productRepository.findById(id);

        if (product1.isPresent()) {
        	Product originalProduct = product1.get();

            if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            	originalProduct.setName(product.getName());
            }
            if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())) {
            	originalProduct.setDescription(product.getDescription());
            }
            if (Objects.nonNull(product.getDiscountPrice()) && product.getDiscountPrice() != 0) {
                originalProduct.setDiscountPrice(product.getDiscountPrice());
            }
            if (Objects.nonNull(product.getPrice()) && product.getPrice() != 0) {
                originalProduct.setPrice(product.getPrice());
            }
            if (Objects.nonNull(product.getQuantity()) && product.getQuantity() != 0) {
                originalProduct.setQuantity(product.getQuantity());
            }
            return productRepository.save(originalProduct);
        }
        return null;
    }

    @Override
    public String deleteProductById(Integer id) {//deleting the records from the mysql db table
        if (productRepository.findById(id).isPresent()) {
        	productRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";//table not present unable to delete the record
    }
}
