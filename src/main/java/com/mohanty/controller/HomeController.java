package com.mohanty.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/test")
	public String testAPI() {
		return "<h1>Testing</h1>";
	}
	
	@GetMapping(value="/welcome")
	public String homepage() {
		return "<h1> Welcome Home </h1>";
	}

	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping(value="/secured/user")
	public String getUser() {
		return "<h1>Hi User!</h1>";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value="/secured/admin")
	public String getAdmin() {
		return "<h1>Hi Admin!</h1>";
	}
	
}

