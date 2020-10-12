package com.backend_reserved.backend_reserved.services;

import com.backend_reserved.backend_reserved.controllers.RestaurantController;
import com.backend_reserved.backend_reserved.entitys.Board;
import com.backend_reserved.backend_reserved.entitys.Reservation;
import com.backend_reserved.backend_reserved.entitys.Restaurant;
import com.backend_reserved.backend_reserved.entitys.Turn;
import com.backend_reserved.backend_reserved.exceptions.BookingExceptions;
import com.backend_reserved.backend_reserved.jsons.RestaurantRest;
import com.backend_reserved.backend_reserved.jsons.TurnRest;
import com.backend_reserved.backend_reserved.repositories.RestaurantRepository;
import com.backend_reserved.backend_reserved.services.implementation.RestaurantServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class RestaurantServiceTest {

    private static final long RESTAURANT_ID = 1L;

    public static final Restaurant RESTAURANT = new Restaurant();

    private static final String NAME = "Burguer";
    private static final String DESCRIPTION = "todo de burguer";
    private static final String ADDRESS = "calle 5 # 4";
    private static final String IMAGE = "image.png";
    public static final List<Turn> TURN = new ArrayList<>();
    public static final List<Board> BOARDS = new ArrayList<>();
    public static final List<Reservation> RESERVATIONS = new ArrayList<>();

    @Mock
    RestaurantRepository restaurantRepository;

    @InjectMocks
    RestaurantServiceImplementation restaurantServiceImplementation;

    @Before
    public void init() throws BookingExceptions {
        MockitoAnnotations.initMocks(this);

        RESTAURANT.setName(NAME);
        RESTAURANT.setDescription(DESCRIPTION);
        RESTAURANT.setAddress(ADDRESS);
        RESTAURANT.setImage(IMAGE);
        RESTAURANT.setId(RESTAURANT_ID);
        RESTAURANT.setTurns(TURN);
        RESTAURANT.setBoards(BOARDS);
        RESTAURANT.setReservations(RESERVATIONS);
    }

    @Test
    public void getRestaurantByIdTest() throws BookingExceptions{
        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT));
        restaurantServiceImplementation.getRestauranById(RESTAURANT_ID);
    }

    @Test(expected = BookingExceptions.class)
    public void getRestaurantByIdNotFound() throws BookingExceptions{
        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty());
        restaurantServiceImplementation.getRestauranById(RESTAURANT_ID);
        fail();
    }

    @Test
    public void getRestaurants() throws BookingExceptions{
        final Restaurant restaurant = new Restaurant();
        Mockito.when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));
        final List<RestaurantRest> response = restaurantServiceImplementation.getRestaurants();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(),1);

    }
}
