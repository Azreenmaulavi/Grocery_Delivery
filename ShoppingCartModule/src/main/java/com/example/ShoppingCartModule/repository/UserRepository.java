package com.example.ShoppingCartModule.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingCartModule.entity.User;
public interface UserRepository extends JpaRepository<User,Long>{
	public User findByEmail(String email);
	

}
