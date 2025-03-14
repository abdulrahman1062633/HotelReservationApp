package com.hotel.management;

import com.hotel.management.console.CommandHandler;
import com.hotel.management.model.Booking;
import com.hotel.management.model.Hotel;
import com.hotel.management.service.HotelService;
import com.hotel.management.utils.FileLoader;

import java.io.IOException;
import java.util.List;

public class HotelReservationApp {
    public static void main(String[] args) {
        try {
            List<Hotel> hotels = FileLoader.loadHotels("src/main/resources/hotels.json");
            List<Booking> bookings = FileLoader.loadBookings("src/main/resources/bookings.json");
            HotelService hotelService = new HotelService(hotels, bookings);
            new CommandHandler(hotelService).start();
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}