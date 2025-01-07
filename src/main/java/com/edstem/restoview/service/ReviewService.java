package com.edstem.restoview.service;

import java.util.List;

import com.edstem.restoview.vo.BaseResponseVO;
import com.edstem.restoview.vo.ReviewVO;

import jakarta.validation.Valid;

public interface ReviewService {
	 List<ReviewVO> findByRestaurantIdAndStatus(Short restaurantId, String status);

	    List<ReviewVO> findByRestaurantId(Long restaurantId);

	    BaseResponseVO addReview(@Valid ReviewVO reviewVO);
}
