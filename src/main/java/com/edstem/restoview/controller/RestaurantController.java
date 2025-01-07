package com.edstem.restoview.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstem.restoview.repository.primary.RestaurantRepository;
import com.edstem.restoview.service.RestaurantService;
import com.edstem.restoview.vo.BaseResponseVO;
import com.edstem.restoview.vo.RestaurantVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	   private RestaurantService restaurantService;
	
	 @PostMapping("/addRestaurant")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<BaseResponseVO> addRestaurant(@Valid @RequestBody RestaurantVO restaurant) {
		 logger.info("Inside AddRestaurant API");
	        BaseResponseVO response = restaurantService.addRestaurant(restaurant);
	        logger.info("Exiting AddRestaurant API");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

	  @GetMapping("/showAllRestaurants")
	   public ResponseEntity<List<RestaurantVO>> getAllRestaurants() {
		  logger.info("Inside showAllRestaurants API");
	       List<RestaurantVO> restaurantVOs = restaurantService.getAllRestaurantsAsVO();
	       logger.info("Exiting showAllRestaurants API");
	       return ResponseEntity.ok(restaurantVOs);
	   }
	  
	  @GetMapping("/showRestaurantById/{id}")
	    public ResponseEntity<RestaurantVO> getRestaurantById(@PathVariable Short id) {
		  logger.info("Inside showRestaurantById API");
	        return restaurantService.findRestaurantById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
}
