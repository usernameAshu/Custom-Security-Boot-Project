package com.mohanty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mohanty.model.CustomUserDetails;
import com.mohanty.model.User;
import com.mohanty.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository usersRepository;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> optionalUsers = usersRepository.findByName(username);

	        optionalUsers
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	        return optionalUsers
	                .map(CustomUserDetails::new).get();
	    }

}
