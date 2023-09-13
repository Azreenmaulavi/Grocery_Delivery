package com.example.crud.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.crud.entity.*;
public interface OrderDetailsRepository  extends CrudRepository<OrderDetails, Integer>{

}
