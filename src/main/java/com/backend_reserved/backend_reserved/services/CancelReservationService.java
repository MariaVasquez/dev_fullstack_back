package com.backend_reserved.backend_reserved.services;

import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;

public interface CancelReservationService {
    String deleteReservation(String locator) throws BookingExceptions;
}
