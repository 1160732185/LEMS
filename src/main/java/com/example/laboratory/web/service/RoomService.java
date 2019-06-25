package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRoom();
    Room getRoomByNo(Integer No);
    void insertRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(Integer No);
}
