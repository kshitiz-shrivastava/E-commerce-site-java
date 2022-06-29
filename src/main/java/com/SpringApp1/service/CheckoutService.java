package com.SpringApp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp1.model.Checkout;
import com.SpringApp1.repository.CheckoutRepository;

@Service
public class CheckoutService {

	@Autowired
	private CheckoutRepository repo;
	
	public List<Checkout> listAll(){
		return (List<Checkout>) repo.findAll();
	}
	
	public void save(Checkout check) {
		repo.save(check);
	}
}
