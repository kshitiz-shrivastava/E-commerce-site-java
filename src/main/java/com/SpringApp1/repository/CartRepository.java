package com.SpringApp1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApp1.model.Cart;
import com.SpringApp1.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	public List<Cart> findByUserId(User user);
	
}
