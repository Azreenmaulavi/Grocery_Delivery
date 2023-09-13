package com.example.crud.repository;
//Hibernate jpa file, here connecting Entity class to service implementation class
//StudentRepository.java
import com.example.crud.entity.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, Long> {
}
