package com.example.ShoppingCartModule.repository;
import com.example.ShoppingCartModule.entity.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Query("SELECT p from Product p Where product.id=:productId")
	public Optional<Product> findById(@Param("productId")Long productId);
	

}
