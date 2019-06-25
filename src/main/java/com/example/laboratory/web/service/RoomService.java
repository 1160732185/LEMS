package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRoomS(Integer staffNo);
    List<Room> getAllRoom();
    Room getRoomByNo(Integer roomNo);
    Room getRoomByNoS(Integer roomNo,Integer staffNo);
    void insertRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(Integer No);
}
