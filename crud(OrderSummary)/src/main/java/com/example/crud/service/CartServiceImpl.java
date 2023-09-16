package com.example.crud.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.crud.repository.*;
import com.example.crud.entity.*;
import com.example.crud.service.*;

@Transactional
@Component
public class CartServiceImpl implements CartService {
	
 @Autowired
 private CartRepository cartDao;
	
 @Autowired
 private UserRepository userDao;

 @Override
 public Cart addCartToUser(Cart cart, long idUser) {
   User user = userDao.findById(idUser).orElse(null);
   user.addCartToUser(cart);
   return userDao.save(cart);
 }

 @Override
 public void deleteCart(long id) {
   userDao.deleteById(id);
 }

 @Override
 public List<Cart> findCartsForUser(long idUser) {
   User user = userDao.findById(idUser).orElse(null);
   return user.getCarts();
 }

@Override
public Cart findCartById(long id) {
	return cartDao.findById(id).orElse(null);
}

@Override
public void removeFromCart(long idCart, long idUser) {
	User user = userDao.findById(idUser).orElse(null);
	   Cart cart = cartDao.findById(idCart).orElse(null);
	   user.removeFromCart(cart);
	   cartDao.delete(cart);
	
}

@Override
public Cart findByCartName(String name) {
	 Optional<Cart> carts = cartDao.findByName(name);
	   if (carts.isPresent()) {
		Cart cart = carts.get();
	    return cart;
	   }
	   return null;
}
}