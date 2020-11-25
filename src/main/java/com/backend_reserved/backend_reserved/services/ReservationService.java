package com.backend_reserved.backend_reserved.services;

import com.backend_reserved.backend_reserved.entitys.Reservation;
import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.CreateReservationRest;
import com.backend_reserved.backend_reserved.jsons.ReservationRest;
import com.backend_reserved.backend_reserved.jsons.RestaurantRest;

import java.util.List;

public interface ReservationService {

    ReservationRest getReservationById(Long reservationId) throws BookingExceptions;

    public List<ReservationRest> getReservationts() throws BookingExceptions;

    String createReservation(CreateReservationRest createReservationRest) throws BookingExceptions;

}
