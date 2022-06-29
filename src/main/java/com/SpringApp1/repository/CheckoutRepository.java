package com.SpringApp1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApp1.model.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer>{

	
}
