package com.SpringApp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.SpringApp1.service.CategoryService;
import com.SpringApp1.service.ProductService;

import global.GlobalCartData;

@Controller
public class UserController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("cartCount", GlobalCartData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProduct());
		model.addAttribute("cartCount", GlobalCartData.cart.size());
		System.out.println("products");
		return "shop";	
		
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id)
	{
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("cartCount", GlobalCartData.cart.size());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id)
	{
		model.addAttribute("product", productService.getProductById(id).get());
		return "viewProduct";
	}
	

	@GetMapping("/Contact")
	public String viewContactPage() {
		return "Contact";
	}
	
	@GetMapping("/send")
	public String viewPage() {
		return "index";
	}
}
