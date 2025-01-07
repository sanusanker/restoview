package com.edstem.restoview.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edstem.restoview.model.primary.PrimaryRestaurants;
import com.edstem.restoview.repository.primary.RestaurantRepository;
import com.edstem.restoview.vo.BaseResponseVO;
import com.edstem.restoview.vo.RestaurantVO;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	 @Autowired
	    private RestaurantRepository restaurantRepository;
	 
	 @Override
	    public BaseResponseVO addRestaurant(RestaurantVO restaurantVO) {
	      
		 	PrimaryRestaurants restaurantEntity = restaurantVO.toEntity();

	        PrimaryRestaurants savedEntity = restaurantRepository.save(restaurantEntity);
	        BaseResponseVO resp = new BaseResponseVO();
	        resp.setStatus(true);
	        return resp;
	    }
	 
	 
	 @Override
	    public Iterable<PrimaryRestaurants> findAllRestaurants() {
	        return restaurantRepository.findAll();
	    }
	  @Override
	    public List<RestaurantVO> getAllRestaurantsAsVO() {
	        Iterable<PrimaryRestaurants> restaurants = findAllRestaurants();
	        return StreamSupport.stream(restaurants.spliterator(), false)
	            .map(this::convertToRestaurantVO)
	            .collect(Collectors.toList());
	    }
	  
	 private RestaurantVO convertToRestaurantVO(PrimaryRestaurants restaurant) {
	        RestaurantVO vo = new RestaurantVO();
	        vo.setName(restaurant.getName());
	        vo.setCuisineType(restaurant.getCuisineType());
	        vo.setAddress(restaurant.getAddress());
	        vo.setPriceRange(restaurant.getPriceRange());
	        return vo;
	    }
	 
	 @Override
	    public Optional<RestaurantVO> findRestaurantById(Short id) {
	        return restaurantRepository.findById(id)
	                .map(this::convertToRestaurantVO); 
	    }
}
