package com.hotel.management.model;

public class Room {
    private String roomType;
    private String roomId;

    public Room() {

    }

    public Room(String roomType, String roomId) {
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
