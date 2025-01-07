package com.edstem.restoview.custom;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.edstem.restoview.model.primary.PrimaryUsers;
import com.edstem.restoview.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	 @Autowired
	    private UserService userService;
	 
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	 
	 @Bean
	    public UserDetailsService userDetailsService(UserService userService) {
	        return username -> {
	            PrimaryUsers user = userService.findByUserName(username);
	            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	        };
	    }
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/users/register").permitAll() // Allow registration
	                .anyRequest().authenticated() // Authenticate all other requests
	            )
	            .httpBasic(); // Use HTTP Basic Authentication
	        return http.build();
	    }

}
