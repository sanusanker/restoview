package com.edstem.restoview.model.primary;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "restaurants", schema = "restaurantManagement")
public class PrimaryRestaurants {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="restaurant_id")
	    private Long restaurantId;

	    @Column(name="name")
	    private String name;

	    @Column(name="address")
	    private String address;

	    @Column(name="cuisine_type")
	    private String cuisineType;
	    
	    @Column(name="price_range")
	    private String priceRange;

		public Long getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(Long restaurantId) {
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

		public PrimaryRestaurants() {
			super();
		}


}
