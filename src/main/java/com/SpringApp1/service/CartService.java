package com.SpringApp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp1.exception.CartNotFoundException;
import com.SpringApp1.model.Cart;
import com.SpringApp1.model.User;
import com.SpringApp1.repository.CartRepository;

@Service
public class CartService {

	
	
	@Autowired
	private CartRepository repo;
	
	public List<Cart> listAll(User user){
		return repo.findByUserId(user);
	}
	
	public void save(Cart ca) {
		repo.save(ca);
	}
	
	public Cart get(int Cart_id) throws CartNotFoundException{
		Optional<Cart> result = repo.findById(Cart_id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new CartNotFoundException("Could not find any coupon with Id" +Cart_id);
	}
	
	public void delete(int Cart_id) throws CartNotFoundException{
		System.out.println(Cart_id+"delete");
		repo.deleteById(Cart_id);
	}

	public Optional<Cart> getCartById(int id) {
		// TODO Auto-generated method stub
		System.out.println("id in the Cart"+id);
		return repo.findById(id);
	}
}
