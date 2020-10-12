package com.backend_reserved.backend_reserved.controller;

import com.backend_reserved.backend_reserved.controllers.ReservationController;
import com.backend_reserved.backend_reserved.controllers.RestaurantController;
import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.CreateReservationRest;
import com.backend_reserved.backend_reserved.jsons.TurnRest;
import com.backend_reserved.backend_reserved.services.ReservationService;
import com.backend_reserved.backend_reserved.services.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationControllerTest {

    private static final long RESTAURANT_ID = 1L;
    private static final String SUCCES_STATUS = "Succes";
    private static final String SUCCES_CODE = "200 OK";
    private static final String SUCCES_MESSAGE = "OK";

    CreateReservationRest CREATE_RESERVATION_REST = new CreateReservationRest();

    private static final Date DATE = new Date();
    private static final long PERSON = 3;
    private static final long TURN = 1;
    private static final String LOCATOR = "Burguer3";

    @Mock
    ReservationService reservationService;

    @InjectMocks
    ReservationController reservationController;

    @Before
    public void init() throws BookingExceptions {
        MockitoAnnotations.initMocks(this);

        CREATE_RESERVATION_REST.setDate(DATE);
        CREATE_RESERVATION_REST.setPerson(PERSON);
        CREATE_RESERVATION_REST.setRestaurantId(RESTAURANT_ID);
        CREATE_RESERVATION_REST.setTurn(TURN);

        Mockito.when(reservationService.createReservation(CREATE_RESERVATION_REST)).thenReturn(LOCATOR);
    }

    @Test
    public void getReservationByIdTest() throws BookingExceptions {

    }

    @Test
    public void createReservationTest() throws BookingExceptions {

    }

}
