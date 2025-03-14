package com.hotel.management.model;

import java.time.LocalDate;

public class Booking {
    private String hotelId;
    private LocalDate arrival;
    private LocalDate departure;
    private String roomType;
    private String roomRate;

    public Booking() {

    }

    public Booking(String hotelId, LocalDate arrival, LocalDate departure, String roomType, String roomRate) {
        this.hotelId = hotelId;
        this.arrival = arrival;
        this.departure = departure;
        this.roomType = roomType;
        this.roomRate = roomRate;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(String roomRate) {
        this.roomRate = roomRate;
    }
}
