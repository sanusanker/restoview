package com.edstem.restoview.repository.primary;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.edstem.restoview.model.primary.PrimaryUsers;

public interface PrimaryUserRepository extends CrudRepository<PrimaryUsers, Short> {
	Optional<PrimaryUsers> findByUserName(String userName);
}
