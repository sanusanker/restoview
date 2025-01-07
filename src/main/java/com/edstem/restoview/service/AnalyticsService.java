package com.edstem.restoview.service;

import java.util.List;

import com.edstem.restoview.vo.RestaurantVO;

public interface AnalyticsService {
	 public Double calculateAverageRating(Short restaurantId);
	 public List<RestaurantVO> getTopRestaurantsByCuisine();
}
