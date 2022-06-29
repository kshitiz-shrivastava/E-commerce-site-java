package com.SpringApp1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "orders")
public class Checkout {

	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length=45)
	private String FirstName;
	
	@Column(length = 45)
	private String LastName;
	
	@Column(length=5000)
	private String Address1;
	
	@Column(length=5000)
	private String Address2;
	
	@Column(length=6)
	private String PinCode;
	
	@Column(length=20)
	private String city;
	
	@Column(length=10)
	private String phone;
	
	@Column(length=255)
	private String Email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cart_id" , referencedColumnName = "cart_id")
	private Cart Cart_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getPinCode() {
		return PinCode;
	}

	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Cart getCart_id() {
		return Cart_id;
	}

	public void setCart_id(Cart cart_id) {
		Cart_id = cart_id;
	}

	
	
	
}
