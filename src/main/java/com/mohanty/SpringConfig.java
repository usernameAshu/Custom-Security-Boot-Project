package com.mohanty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mohanty.repository.UserRepository;
import com.mohanty.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SpringConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	/*
	 * Authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);

	}

	/*
	 * Authorization
	 */

	  @Override protected void configure(HttpSecurity http) throws Exception {
	  
		  http.csrf().disable();
	        http.authorizeRequests()
	                .antMatchers("**/secured/**").authenticated()
	                .anyRequest().permitAll()
	                .and()
	                .formLogin().permitAll();
	  
	  }
	  
	  /*
	   * Password encoding
	   */
	  
	  @Bean public PasswordEncoder getPasswordEncoder() { return
			  NoOpPasswordEncoder.getInstance(); }


	
}
