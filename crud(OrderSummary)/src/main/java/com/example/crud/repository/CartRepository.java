package com.example.crud.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
   Optional<Cart> findByName(String name);
}

