package com.backend_reserved.backend_reserved.controllers;

import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.CreateReservationRest;
import com.backend_reserved.backend_reserved.services.CancelReservationService;
import com.backend_reserved.backend_reserved.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import response.BookingResponse;

@CrossOrigin(origins="http//localhost:4200")
@RestController
@RequestMapping("/api/booking-restaurant/")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    CancelReservationService cancelReservationService;

    @DeleteMapping("cancelReservation/{locator}")
    public BookingResponse<String> cancelateReservation(@PathVariable String locator) throws BookingExceptions {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                cancelReservationService.deleteReservation(locator));
    }

    @PostMapping("createReservation")
    public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest) throws BookingExceptions {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                reservationService.createReservation(createReservationRest));
    }

}
