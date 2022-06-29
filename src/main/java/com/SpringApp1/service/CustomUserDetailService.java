package com.SpringApp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.SpringApp1.model.CustomUserDetails;
import com.SpringApp1.model.Products;
import com.SpringApp1.model.User;
import com.SpringApp1.repository.ProductRepository;
import com.SpringApp1.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Optional<User> user = userRepository.findUserByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("User not Found"));
		
		return user.map(CustomUserDetails::new).get();
	}
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Integer id)
	{
		System.out.println("hello User"+id);
		return userRepository.findById(id);
	}

}
