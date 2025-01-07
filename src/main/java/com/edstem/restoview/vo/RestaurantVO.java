package com.edstem.restoview.vo;

import com.edstem.restoview.model.primary.PrimaryRestaurants;

public class RestaurantVO {
	private Short restaurantId;
	private String name;
	private String address;
	private String cuisineType;
     private String priceRange;
     private Double averageRating;
     
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public Short getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Short restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	 public PrimaryRestaurants toEntity() {
	        PrimaryRestaurants entity = new PrimaryRestaurants();
	        entity.setName(this.name);
	        entity.setCuisineType(this.cuisineType);
	        entity.setAddress(this.address);
	        entity.setPriceRange(this.priceRange);
	        return entity;
	    }
	 public RestaurantVO convertToRestaurantVO(PrimaryRestaurants entity) {
	        RestaurantVO vo = new RestaurantVO();
	        vo.setName(entity.getName());
	        vo.setCuisineType(entity.getCuisineType());
	        vo.setAddress(entity.getAddress());
	        vo.setPriceRange(entity.getPriceRange());
	        return vo;
	    }
}
