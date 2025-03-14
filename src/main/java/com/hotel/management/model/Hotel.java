package com.hotel.management.model;

import java.util.List;

public class Hotel {
    private String id;
    private String name;
    private List<RoomType> roomTypes;
    private List<Room> rooms;

    public Hotel() {

    }

    public Hotel(String id, String name, List<RoomType> roomTypes, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.roomTypes = roomTypes;
        this.rooms = rooms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }
}
