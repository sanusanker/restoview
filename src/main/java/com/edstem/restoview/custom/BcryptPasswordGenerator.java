package com.edstem.restoview.custom;

import org.springframework.security.crypto.bcrypt.BCrypt;

public interface BcryptPasswordGenerator {
	static String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());		
	}
	
	static boolean matchPassword(String password,String hashPassword) {
		return BCrypt.checkpw(password, hashPassword);
	}
}
