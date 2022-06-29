package com.SpringApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringApp1.exception.CartNotFoundException;
import com.SpringApp1.model.Cart;
import com.SpringApp1.model.Products;
import com.SpringApp1.service.CartService;
import com.SpringApp1.service.CustomUserDetailService;
import com.SpringApp1.service.ProductService;

import global.GlobalCartData;

@Controller
public class CartController {
	
	@Autowired
	private CustomUserDetailService userService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService service;
	
//	@GetMapping("/cart")
//	public String showCartList(Model model) {
//		List<Cart> listCart = service.listAll(null);
//		model.addAttribute("listCart", listCart);
//		model.addAttribute("pageTitle", "Shopping Cart");
//		return "cart";
//	}
	
//	@GetMapping("/addToCart/{id}")
//	public String addToCart(@PathVariable int id,Model model)
//	{
//		model.addAttribute(productService.getProductById(id).get());
//		GlobalCartData.cart.add(productService.getProductById(id).get());
//		return "redirect:/shop";
//	}
	
	@GetMapping("/addToCart/{id}")
//	public String hello(){
//		System.out.println("Hello");
//		return null;
//	}
//	public String saveCart(@PathVariable("id") int id, Cart ca,Model model,RedirectAttributes ra) {
		public String saveCart(@PathVariable("id") int id , Cart ca,Model model,RedirectAttributes ra) {
		System.out.println("hello");
		GlobalCartData.cart.add(productService.getProductById(id).get());
		ca.setUser(userService.getUserById(1).get());
		ca.setProduct(productService.getProductById(id).get());
		System.out.println(userService.getUserById(1).get());
		service.save(ca);
		System.out.println(id);
		model.addAttribute( "User",userService.getUserById(1).get());
		model.addAttribute("Products",productService.getProductById(id).get());
		System.out.println(ca+","+id);
		ra.addFlashAttribute("message", "The item is added successfully");
		return "redirect:/shop";
//		return null;
	}
	
	
	
	@GetMapping("/cart")
	public String cartGet(Model model)
	{
		model.addAttribute("cartCount", GlobalCartData.cart.size());
		model.addAttribute("total", GlobalCartData.cart.stream().mapToDouble(Products::getPrice).sum());
		model.addAttribute("cart", GlobalCartData.cart);
		return "cart";
	}
	
	@GetMapping("/cart/removeItem/{index}/{Cart_id}")
	public String cartItemRemove(@PathVariable int index,Model model,RedirectAttributes ra)
	{
//		int c = Integer.parseInt(Cart_id);
//		System.out.println(cart);
//		try {
//			for(int i=2;i<=100;i++) {
//				System.out.println("for loop");
//			service.delete(i);
//			}
//			
//		}
//		catch(CartNotFoundException e){
//			e.printStackTrace();
//			ra.addAttribute("message",e.getMessage());
//		}
		GlobalCartData.cart.remove(index);
//		GlobalCartData.cart(index);
		return "redirect:/cart";
	}
	
}
