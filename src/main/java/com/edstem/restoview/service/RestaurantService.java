package com.edstem.restoview.service;

import java.util.List;
import java.util.Optional;

import com.edstem.restoview.model.primary.PrimaryRestaurants;
import com.edstem.restoview.vo.BaseResponseVO;
import com.edstem.restoview.vo.RestaurantVO;

public interface RestaurantService {

	Iterable<PrimaryRestaurants> findAllRestaurants();

	List<RestaurantVO> getAllRestaurantsAsVO();

	BaseResponseVO addRestaurant(RestaurantVO restaurantVO);

	Optional<RestaurantVO> findRestaurantById(Short id);

}
