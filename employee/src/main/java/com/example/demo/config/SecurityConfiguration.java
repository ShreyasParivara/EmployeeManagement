package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.service.ServicesImpl;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private ServicesImpl service;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.httpBasic().and()
	       .authorizeRequests()
	       .antMatchers("/register" , "/register/**","/login", "/login/**","/delete","/delete/**","/add","/add/**")
	       .permitAll().anyRequest().authenticated()
	       .and().csrf().disable();

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
		
	
	}
	

}
