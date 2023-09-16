package com.example.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud.entity.OrderProduct;
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
