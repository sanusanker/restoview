package com.edstem.restoview.repository.secondary;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.edstem.restoview.model.secondary.SecondaryReviews;

public interface SecondaryReviewRepository extends CrudRepository<SecondaryReviews, Short> {

    List<SecondaryReviews> findByRestaurantIdAndStatus(Short restaurantId, String status);

    List<SecondaryReviews> findByRestaurantId(Short restaurantId);
    
    @Query("SELECT AVG(r.rating) FROM SecondaryReviews r WHERE r.restaurant.id = :restaurantId AND r.status = 'APPROVED'")
    Double findAverageRatingByRestaurantId(@Param("restaurantId") Short restaurantId);
   
}
