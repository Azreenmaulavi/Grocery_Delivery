package com.example.ShoppingCartModule.repository;
import com.example.ShoppingCartModule.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ShoppingCartModule.entity.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem,Long>{
	@Query("SELECT ci From CartItem ci where ci.cart=:cart And ci.product=:product And ci.userId=:userId")
	public CartItem isCartItemExist(@Param("cart")Cart cart,@Param("product")Product product,@Param("userId")Long userId);

}
