package com.edstem.restoview.model.secondary;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
public class SecondaryReviews {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long reviewId;

	    @ManyToOne
	    @JoinColumn(name = "restaurant_id", nullable = false)
	    private SecondaryRestaurants restaurant;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private SecondaryUsers user;

	    @Column(name = "rating", nullable = false)
	    private int rating;

	    private String comment;

	    @Column(name = "review_date",nullable = false, updatable = false)
	    private LocalDateTime reviewDate = LocalDateTime.now();
	    
	    @Column(name = "status", nullable = false)
	    private String status;

		public Long getReviewId() {
			return reviewId;
		}

		public void setReviewId(Long reviewId) {
			this.reviewId = reviewId;
		}

		public SecondaryRestaurants getRestaurant() {
			return restaurant;
		}

		public void setRestaurant(SecondaryRestaurants restaurant) {
			this.restaurant = restaurant;
		}

		public SecondaryUsers getUser() {
			return user;
		}

		public void setUser(SecondaryUsers user) {
			this.user = user;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public LocalDateTime getReviewDate() {
			return reviewDate;
		}

		public void setReviewDate(LocalDateTime reviewDate) {
			this.reviewDate = reviewDate;
		}

		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public SecondaryReviews() {
			super();
		}

	
	    

}
