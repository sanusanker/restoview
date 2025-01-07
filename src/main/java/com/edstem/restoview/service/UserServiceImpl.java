package com.edstem.restoview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edstem.restoview.model.primary.PrimaryUsers;
import com.edstem.restoview.repository.primary.PrimaryUserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
    private PrimaryUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public PrimaryUsers registerUser(PrimaryUsers user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
        return userRepository.save(user);
    }

    @Override
    public PrimaryUsers findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + userName));
    }

	

}
