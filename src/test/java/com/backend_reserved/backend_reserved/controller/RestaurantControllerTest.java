package com.backend_reserved.backend_reserved.controller;

import com.backend_reserved.backend_reserved.controllers.RestaurantController;
import com.backend_reserved.backend_reserved.entitys.Restaurant;
import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.RestaurantRest;
import com.backend_reserved.backend_reserved.jsons.TurnRest;
import com.backend_reserved.backend_reserved.services.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import response.BookingResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestaurantControllerTest {

    private static final long RESTAURANT_ID = 1L;
    private static final String SUCCES_STATUS = "Succes";
    private static final String SUCCES_CODE = "200 OK";
    private static final String SUCCES_MESSAGE = "OK";

    public static final RestaurantRest RESTAURANT_REST = new RestaurantRest();
    public static final List<TurnRest> TURN_REST = new ArrayList<>();

    private static final String NAME = "Burguer";
    private static final String DESCRIPTION = "todo de burguer";
    private static final String ADDRESS = "calle 5 # 4";
    private static final String IMAGE = "image.png";

    public static final List<RestaurantRest> RESTAURANT_REST_LIST = new ArrayList<>();

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @Before
    public void init() throws BookingExceptions{
        MockitoAnnotations.initMocks(this);

        RESTAURANT_REST.setName(NAME);
        RESTAURANT_REST.setDescription(DESCRIPTION);
        RESTAURANT_REST.setAddress(ADDRESS);
        RESTAURANT_REST.setImage(IMAGE);
        RESTAURANT_REST.setId(RESTAURANT_ID);
        RESTAURANT_REST.setTurns(TURN_REST);

        Mockito.when(restaurantService.getRestauranById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);
    }

    @Test
    public void getRestaurantByIdTest() throws BookingExceptions{
        final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantId(RESTAURANT_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), SUCCES_MESSAGE);
        assertEquals(response.getData(), RESTAURANT_REST);

    }

    @Test
    public void getRestaurants() throws BookingExceptions{
        final BookingResponse<List<RestaurantRest>> response = restaurantController.getRestaurants();

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), SUCCES_MESSAGE);
        assertEquals(response.getData(), RESTAURANT_REST_LIST);
    }
}
