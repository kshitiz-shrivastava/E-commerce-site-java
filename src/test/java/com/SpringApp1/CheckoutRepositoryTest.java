package com.SpringApp1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.SpringApp1.model.Checkout;
import com.SpringApp1.model.Coupons;
import com.SpringApp1.repository.CheckoutRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CheckoutRepositoryTest {
	@Autowired
	private CheckoutRepository repo;
	
	@Test
	public void testAddNew() {
		Checkout check = new Checkout();
		check.setFirstName("Akhilesh");
		check.setLastName("Kolipakula");
		check.setAddress1("Flat no:403");
		check.setAddress2("Veternary colony");
		check.setCity("Vijayawada");
		check.setPinCode("520008");
		check.setPhone("6301784730");
		check.setEmail("akhil@gmail.com");
		
		Checkout savedCheckout = repo.save(check);
		
		Assertions.assertThat(savedCheckout).isNotNull();
		Assertions.assertThat(savedCheckout.getId()).isGreaterThan(0);
	}
}
