package com.hotel.management.service;

import com.hotel.management.model.Booking;
import com.hotel.management.model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelService {
    private final List<Hotel> hotels;
    private final List<Booking> bookings;

    public HotelService(List<Hotel> hotels, List<Booking> bookings) {
        this.hotels = hotels;
        this.bookings = bookings;
    }

    public int checkAvailability(String hotelId, LocalDate startDate, LocalDate endDate, String roomType) {
        Optional<Hotel> hotelOpt = hotels.stream().filter(h -> h.getId().equals(hotelId)).findFirst();
        if (hotelOpt.isEmpty()) return -1;

        Hotel hotel = hotelOpt.get();
        long totalRooms = hotel.getRooms().stream().filter(r -> r.getRoomType().equals(roomType)).count();
        long bookedRooms = bookings.stream()
                .filter(b -> b.getHotelId().equals(hotelId) && b.getRoomType().equals(roomType))
                .filter(b -> !(b.getDeparture().isBefore(startDate) || b.getArrival().isAfter(endDate)))
                .count();

        return (int) (totalRooms - bookedRooms);
    }

    public List<String> searchAvailability(String hotelId, int daysAhead, String roomType) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(daysAhead);
        List<String> availability = new ArrayList<>();

        for (LocalDate date = today; date.isBefore(endDate); date = date.plusDays(1)) {
            int availableRooms = checkAvailability(hotelId, date, date, roomType);
            if (availableRooms > 0) {
                availability.add(String.format("(%s-%s, %d)", date, date.plusDays(1), availableRooms));
            }
        }
        return availability;
    }

}
