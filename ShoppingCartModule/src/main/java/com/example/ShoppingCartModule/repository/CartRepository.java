package com.example.ShoppingCartModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.example.ShoppingCartModule.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
	
	@Query("SELECT c from Cart c Where user.id=:userId")
	public Cart findByUserId(@Param("userId")Long userId);

}
