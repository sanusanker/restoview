package com.edstem.restoview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstem.restoview.service.ReviewService;
import com.edstem.restoview.vo.BaseResponseVO;
import com.edstem.restoview.vo.ReviewVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private ReviewService reviewService;
	
	@PostMapping("/addReview")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BaseResponseVO> addReview(@RequestBody @Valid ReviewVO reviewVO) {
		 logger.info("Inside AddReview API");
        BaseResponseVO response = reviewService.addReview(reviewVO);
        logger.info("Exiting AddReview API");
        return ResponseEntity.status(response.getStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }
}
