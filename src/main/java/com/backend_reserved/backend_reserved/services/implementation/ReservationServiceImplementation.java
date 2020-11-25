package com.backend_reserved.backend_reserved.services.implementation;

import com.backend_reserved.backend_reserved.entitys.Reservation;
import com.backend_reserved.backend_reserved.entitys.Restaurant;
import com.backend_reserved.backend_reserved.entitys.Turn;
import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.exceptions.ExistingLocatorError;
import com.backend_reserved.backend_reserved.exceptions.InternalExceptionError;
import com.backend_reserved.backend_reserved.exceptions.NotFoundException;
import com.backend_reserved.backend_reserved.jsons.CreateReservationRest;
import com.backend_reserved.backend_reserved.jsons.ReservationRest;
import com.backend_reserved.backend_reserved.repositories.ReservationRepository;
import com.backend_reserved.backend_reserved.repositories.RestaurantRepository;
import com.backend_reserved.backend_reserved.repositories.TurnRepository;
import com.backend_reserved.backend_reserved.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImplementation implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Reservation.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationRest getReservationById(Long reservationId) throws BookingExceptions {
        return null;
    }

    public List<ReservationRest> getReservationts() throws BookingExceptions {
        return null;
    }

    private String generateLocator(Restaurant restaurant, CreateReservationRest createReservationRest) throws BookingExceptions{
        return restaurant.getName() + createReservationRest.getTurn();
    }

}
