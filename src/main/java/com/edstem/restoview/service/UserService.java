package com.edstem.restoview.service;

import com.edstem.restoview.model.primary.PrimaryUsers;

public interface UserService {
	PrimaryUsers registerUser(PrimaryUsers user);
    PrimaryUsers findByUserName(String userName);
}
