package com.edstem.restoview.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstem.restoview.model.primary.PrimaryUsers;
import com.edstem.restoview.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<PrimaryUsers> registerUser(@Validated @RequestBody PrimaryUsers user) {
	    	 logger.info("Inside register API");
	        PrimaryUsers savedUser = userService.registerUser(user);
	        logger.info("Exiting register API");
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	    }

	    @GetMapping("/ShowcurrentUser")
	    public ResponseEntity<?> getCurrentUser(Principal principal) {
	    	 logger.info("Inside ShowcurrentUser API");
	        String userName = principal.getName();
	        PrimaryUsers user = userService.findByUserName(userName);
	        logger.info("Exiting ShowcurrentUser API");
	        return ResponseEntity.ok(user);
	    }
}
