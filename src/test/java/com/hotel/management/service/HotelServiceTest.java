package com.hotel.management.service;

import com.hotel.management.model.Booking;
import com.hotel.management.model.Hotel;
import com.hotel.management.model.Room;
import com.hotel.management.model.RoomType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelServiceTest {

    private HotelService hotelService;

    @BeforeEach
    public void setUp() {
        RoomType singleRoomType = new RoomType("SGL", "Single Room", Arrays.asList("WiFi", "TV"), Arrays.asList("Non-smoking"));
        RoomType doubleRoomType = new RoomType("DBL", "Double Room", Arrays.asList("WiFi", "TV", "Minibar"), Arrays.asList("Non-smoking", "Sea View"));
        Room room1 = new Room("SGL", "101");
        Room room2 = new Room("SGL", "102");
        Room room3 = new Room("DBL", "201");
        Room room4 = new Room("DBL", "202");
        Hotel hotel = new Hotel("H1", "Hotel California", List.of(singleRoomType, doubleRoomType), List.of(room1, room2, room3, room4));
        List<Hotel> hotels = Collections.singletonList(hotel);

        Booking booking = new Booking("H1", LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 2), "SGL", "101");
        List<Booking> bookings = Collections.singletonList(booking);

        hotelService = new HotelService(hotels, bookings);
    }

    @Test
    void testCheckAvailability() {
        int availableRooms = hotelService.checkAvailability("H1", LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 2), "SGL");
        assertEquals(1, availableRooms);
    }

    @Test
    void testSearchAvailability() {
        List<String> availability = hotelService.searchAvailability("H1", 5, "SGL");
        assertEquals(5, availability.size());
    }
}