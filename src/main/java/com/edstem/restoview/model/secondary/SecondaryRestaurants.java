package com.edstem.restoview.model.secondary;

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
public class SecondaryRestaurants {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="restaurant_id")
	    private Long restaurantId;

	    @Column(name="name")
	    private String name;

	    @Column(name="address")
	    private String address;

	    @Column(name="cuisineType")
	    private String cuisineType;
	    
	    @Column(name="priceRange")
	    private String price_range;

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

		public String getPrice_range() {
			return price_range;
		}

		public void setPrice_range(String price_range) {
			this.price_range = price_range;
		}

		public SecondaryRestaurants() {
			super();
		}
	    
	    

}
