package com.edstem.restoview.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edstem.restoview.model.secondary.SecondaryReviews;
import com.edstem.restoview.repository.secondary.SecondaryReviewRepository;
import com.edstem.restoview.vo.BaseResponseVO;
import com.edstem.restoview.vo.ReviewVO;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
	 @Autowired
	    private SecondaryReviewRepository reviewRepository;
	 
	 public BaseResponseVO addReview(ReviewVO reviewVO) {
		 BaseResponseVO resp = new BaseResponseVO();
	        try {
	            SecondaryReviews review = new SecondaryReviews();
	             review.setRating(reviewVO.getRating());
	            review.setComment(reviewVO.getComment());
	            review.setReviewDate(reviewVO.getReviewDate());
	            review.setStatus("pending");
	            reviewRepository.save(review);
	            
		        resp.setStatus(true);
	        } catch (Exception e) {
	            		resp.setStatus(false);
	        }
			return resp;
	    }
	 public List<ReviewVO> getReviewsByRestaurantId(Short restaurantId) {
	        List<SecondaryReviews> reviews = reviewRepository.findByRestaurantId(restaurantId);

	        return reviews.stream().map(this::convertToReviewVO).collect(Collectors.toList());
	    }
	 private ReviewVO convertToReviewVO(SecondaryReviews review) {
	        ReviewVO vo = new ReviewVO();
	        vo.setRating(review.getRating());
	        vo.setComment(review.getComment());
	        vo.setReviewDate(review.getReviewDate());
	        vo.setStatus(review.getStatus().toString());
	        return vo;
	    }
	@Override
	public List<ReviewVO> findByRestaurantIdAndStatus(Short restaurantId, String status) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ReviewVO> findByRestaurantId(Long restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}
}
