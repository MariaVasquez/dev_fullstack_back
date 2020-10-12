package com.backend_reserved.backend_reserved.controllers;

import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.RestaurantRest;
import com.backend_reserved.backend_reserved.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import response.BookingResponse;

import java.util.List;

@CrossOrigin(origins="http//localhost:4200")
@RestController
@RequestMapping("/api/booking-restaurant/")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("restaurant/{id}")
    public BookingResponse<RestaurantRest> getRestaurantId(@PathVariable long id) throws BookingExceptions{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestauranById(id));
    }

    @GetMapping("restaurants")
    public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingExceptions{
        return new BookingResponse<List<RestaurantRest>>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
    }

}
