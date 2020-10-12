package com.backend_reserved.backend_reserved.services.implementation;

import com.backend_reserved.backend_reserved.entitys.Restaurant;
import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.exceptions.NotFoundException;
import com.backend_reserved.backend_reserved.jsons.RestaurantRest;
import com.backend_reserved.backend_reserved.repositories.RestaurantRepository;
import com.backend_reserved.backend_reserved.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImplementation implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    public RestaurantRest getRestauranById(Long restaurantId) throws BookingExceptions {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    public List<RestaurantRest> getRestaurants() throws BookingExceptions {
        final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(services -> modelMapper.map(services, RestaurantRest.class))
                .collect(Collectors.toList());
    }

    private Restaurant getRestaurantEntity(long restaurantId) throws BookingExceptions {
        return restaurantRepository.findById(restaurantId).orElseThrow(()-> new NotFoundException("SNOT - 404-1", "RESTAURANT_NOT_FOUND"));
    }


}
