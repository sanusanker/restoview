package com.edstem.restoview.repository.secondary;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.edstem.restoview.model.secondary.SecondaryRestaurants;

public interface SecondaryRestaurantRepository extends CrudRepository<SecondaryRestaurants, Short> {
	 @Query("""
	    	    SELECT r.cuisineType, res.id, res.name, AVG(rv.rating) AS avgRating
	    	    FROM SecondaryRestaurants res
	    	    JOIN SecondaryReviews rv ON res.restaurantId = rv.restaurant
	    	    WHERE rv.status = 'APPROVED'
	    	    GROUP BY res.cuisineType, res.restaurantId, res.name
	    	    ORDER BY avgRating DESC
	    	""")
	    	List<Object[]> findTopRestaurantsByCuisine();

}
