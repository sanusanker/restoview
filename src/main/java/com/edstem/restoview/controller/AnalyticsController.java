package com.edstem.restoview.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstem.restoview.service.AnalyticsService;
import com.edstem.restoview.vo.RestaurantVO;


@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
	
	@Autowired
    private AnalyticsService analyticsService;
	
	
	 @GetMapping("/average-rating/{restaurantId}")
	    public ResponseEntity<Double> getAverageRating(@PathVariable Short restaurantId) {
	        Double averageRating = analyticsService.calculateAverageRating(restaurantId);
	        return ResponseEntity.ok(averageRating);
	    }
	 
	 
	 @GetMapping("/top-restaurants")
	    public ResponseEntity<List<RestaurantVO>> getTopRestaurants() {
	        List<RestaurantVO> topRestaurants = analyticsService.getTopRestaurantsByCuisine();
	        return ResponseEntity.ok(topRestaurants);
	    }
}
