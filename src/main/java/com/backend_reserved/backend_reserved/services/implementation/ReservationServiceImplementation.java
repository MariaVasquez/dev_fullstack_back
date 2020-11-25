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

    public String createReservation(CreateReservationRest createReservationRest) throws BookingExceptions {

        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
                .orElseThrow(()-> new NotFoundException("RESTAURANT_NOT_FOUND","RESTAURANT_NOT_FOUND"));

        final Turn turnId = turnRepository.findById(createReservationRest.getTurn())
                .orElseThrow(()-> new NotFoundException("TURN_NOT_FOUND","TURN_NOT_FOUND"));

        String locator = generateLocator(restaurantId, createReservationRest);

        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        reservation.setDate(createReservationRest.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turnId.getName());

        try {
            reservationRepository.save(reservation);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalExceptionError("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return locator;
    }

}
