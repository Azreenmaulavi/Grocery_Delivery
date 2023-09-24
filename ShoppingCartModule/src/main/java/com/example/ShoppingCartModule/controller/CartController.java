package com.example.ShoppingCartModule.controller;
import com.example.ShoppingCartModule.service.*;
import com.example.ShoppingCartModule.exception.*;
import com.example.ShoppingCartModule.request.AddItemRequest;
import com.example.ShoppingCartModule.response.ApiResponse;
import org.springframework.web.bind.annotation.RequestHeader;
import com.example.ShoppingCartModule.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")

public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<Cart>findUserCart(@RequestHeader("Authorization")String jwt) throws UserException{
		User user=userService.findUserProfileByJwt(jwt);
		Cart cart=cartService.findUserCart(user.getUserId());
		return new ResponseEntity<Cart>(cart,HttpStatus.OK); 
	}
	
	@PutMapping("/add")
	public ResponseEntity<ApiResponse>addItemToCart(@RequestBody AddItemRequest req,@RequestHeader("Authorization")String jwt)throws UserException,ProductException{
		User user=userService.findUserProfileByJwt(jwt);
		cartService.addCartItem(user.getUserId(), req);
		
		ApiResponse res=new ApiResponse();
		res.setMessage("Item added to cart");
		res.setStatus(true);
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}

}
