package com.edstem.restoview.repository.secondary;
import org.springframework.data.repository.CrudRepository;

import com.edstem.restoview.model.primary.PrimaryUsers;

public interface SecondaryUserRepository extends CrudRepository<PrimaryUsers, Short> {

}
