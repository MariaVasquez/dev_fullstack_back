package com.backend_reserved.backend_reserved.services;

import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.RestaurantRest;

import java.util.List;

public interface RestaurantService {

    RestaurantRest getRestauranById(Long restaurantId) throws BookingExceptions;

    List<RestaurantRest> getRestaurants() throws BookingExceptions;

}
