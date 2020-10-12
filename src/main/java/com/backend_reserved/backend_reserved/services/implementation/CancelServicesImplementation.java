package com.backend_reserved.backend_reserved.services.implementation;

import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.exceptions.InternalExceptionError;
import com.backend_reserved.backend_reserved.exceptions.NotFoundException;
import com.backend_reserved.backend_reserved.repositories.ReservationRepository;
import com.backend_reserved.backend_reserved.services.CancelReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelServicesImplementation implements CancelReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelServicesImplementation.class);

    @Autowired
    private ReservationRepository reservationRepository;

    public String deleteReservation(String locator) throws BookingExceptions {
        reservationRepository.findByLocator(locator)
                .orElseThrow(()-> new NotFoundException("LOCATOR_NOT_FOUND","LOCATOR_NOT_FOUND"));

        try {
            reservationRepository.deleteByLocator(locator);

        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalExceptionError("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return "LOCATOR_DELETE";
    }


}
