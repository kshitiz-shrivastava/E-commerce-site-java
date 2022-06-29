package com.SpringApp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringApp1.model.Checkout;
import com.SpringApp1.model.Products;
import com.SpringApp1.service.CartService;
import com.SpringApp1.service.CheckoutService;

import global.GlobalCartData;

@Controller
public class CheckoutController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private CheckoutService service;
	
	@GetMapping("/checkout")
	public String checkout(Model model)
	{
		model.addAttribute("total", GlobalCartData.cart.stream().mapToDouble(Products::getPrice).sum());
		return "checkout";
	}
	
	@GetMapping("/checkout/save")
	public String saveCheckout(Checkout check, RedirectAttributes ra,Model model) {
		System.out.println("comming to checkout");
//		check.setCart_id(cartservice.getCartById(id).get());
		service.save(check);
//		model.addAttribute( "User",cartservice.getCartById(id).get());
		ra.addAttribute("message","The checkout has been added successfully");
		GlobalCartData.cart.clear();
		return "redirect:/shop";
	}
}
