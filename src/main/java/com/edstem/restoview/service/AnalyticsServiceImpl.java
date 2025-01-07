package com.edstem.restoview.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edstem.restoview.repository.primary.RestaurantRepository;
import com.edstem.restoview.repository.secondary.SecondaryRestaurantRepository;
import com.edstem.restoview.repository.secondary.SecondaryReviewRepository;
import com.edstem.restoview.vo.RestaurantVO;

@Service
@Transactional
public class AnalyticsServiceImpl {
	@Autowired
    private SecondaryReviewRepository reviewRepository;

    @Autowired
    private SecondaryRestaurantRepository restaurantRepository;
    
    public Double calculateAverageRating(Short restaurantId) {
        Double averageRating = reviewRepository.findAverageRatingByRestaurantId(restaurantId);
        return averageRating != null ? averageRating : 0.0;
    }
    public List<RestaurantVO> getTopRestaurantsByCuisine() {
        List<Object[]> queryResults = restaurantRepository.findTopRestaurantsByCuisine();

        return queryResults.stream()
                .map(result -> {
                	RestaurantVO vo = new RestaurantVO();
                    vo.setCuisineType((String) result[0]);
                    vo.setRestaurantId((Short) result[1]);
                    vo.setName((String) result[2]);
                    vo.setAverageRating((Double) result[3]);
                    return vo;
                })
                .limit(3) // Limit to top 3
                .collect(Collectors.toList());
    }
}
