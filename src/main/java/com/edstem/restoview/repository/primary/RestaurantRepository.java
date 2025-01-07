package com.edstem.restoview.repository.primary;

import org.springframework.data.repository.CrudRepository;

import com.edstem.restoview.model.primary.PrimaryRestaurants;

public interface RestaurantRepository extends CrudRepository<PrimaryRestaurants, Short>{

}
