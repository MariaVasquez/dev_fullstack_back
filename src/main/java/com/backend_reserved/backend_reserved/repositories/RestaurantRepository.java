package com.backend_reserved.backend_reserved.repositories;

import com.backend_reserved.backend_reserved.entitys.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findById(long id);

    Optional<Restaurant> findByName(String nameRestaurant);

    @Query(value = "SELECT * FROM restaurant", nativeQuery = true)
    List<Restaurant> findRestaurants();

}
