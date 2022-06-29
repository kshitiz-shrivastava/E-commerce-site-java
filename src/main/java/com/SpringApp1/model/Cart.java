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
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int Cart_id;
	
	@Column
	private int quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "Product_id")
	private Products Product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_id", referencedColumnName = "id")
	private User user;
	public int getCart_id() {
		return Cart_id;
	}
	public void setCart_id(int cart_id) {
		Cart_id = cart_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public Products getProduct() {
		return Product;
	}
	public void setProduct(Products product) {
		Product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Coupons{"+"Id="+Cart_id+", quantity="+quantity+'\''+"Product"+Product+'\''+"user="+user+'\''+ '}';
	}
}
