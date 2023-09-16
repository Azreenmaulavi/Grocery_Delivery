package com.example.crud.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entity.Cart;
import com.example.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
 Optional<User> findByUsername(String name);

Cart save(Cart cart);
}

