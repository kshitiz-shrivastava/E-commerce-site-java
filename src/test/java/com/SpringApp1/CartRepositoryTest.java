package com.SpringApp1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.SpringApp1.model.Cart;
import com.SpringApp1.model.Products;
import com.SpringApp1.model.User;
import com.SpringApp1.repository.CartRepository;
import com.SpringApp1.repository.ProductRepository;
import com.SpringApp1.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CartRepositoryTest {

//	@Autowired
//	private ProductRepository repo1;
//	
//	@Autowired
//	private UserRepository repo2;
	
	@Autowired
	private CartRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddone() {
		Products Product = entityManager.find(Products.class, 7);
		User user = entityManager.find(User.class, 1);
		Cart ca = new Cart();
		ca.setUser(user);
		ca.setProduct(Product);
		ca.setQuantity(2);
		
		Cart savedCart = repo.save(ca);
		
//		assertTrue(savedCart.getCart_id() > 0);
		
//     	Assertions.assertThat(savedCart.getCart_id()>0);
	}
	
//	@Test
//	public void testListAll() {
//		Iterable<Cart> car = repo.findAll();
//		Assertions.assertThat(car).hasSizeGreaterThan(0);
//		
//		for(Cart ca : car) {
//			System.out.println(ca);
//		}
//	}
	
	@Test
	public void testGetItemsByUser() {
		
		User user = new User();
		user.setId(1);
		
//		List<Cart> cart = repo.findByUserId(user);
//		Assertions.assertThat(2).isEqualTo(cart.size());
//		Integer Cart_id = 2;
//		Optional<Cart> optionalCart = repo.findById(Cart_id);
//		Assertions.assertThat(optionalCart).isPresent();
//		System.out.println(optionalCart.get());
	}
	
	@Test
	public void testDelete() {
		Integer Cart = 2;
		repo.deleteById(Cart);
		
		Optional<Cart> optionalCart = repo.findById(Cart);
		Assertions.assertThat(optionalCart).isPresent();
	}
}
