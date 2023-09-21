package com.example.ShoppingCartModule.service;
import com.example.ShoppingCartModule.entity.*;
import com.example.ShoppingCartModule.exception.*;

public interface UserService {
	public User findUserById(Long userId)throws UserException;
	public User findUserProfileByJwt(String jwt)throws UserException;
	

}
