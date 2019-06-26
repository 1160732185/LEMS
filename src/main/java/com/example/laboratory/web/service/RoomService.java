package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Room;
import java.util.List;

public interface RoomService {
    Integer getRoomCount();
    Integer getRoomCountS(Integer staffNo);
    List<Room> getAllRoomS(Integer staffNo,Integer firstRow,Integer pageSize);
    List<Room> getAllRoom(Integer firstRow,Integer pageSize);
    Room getRoomByNo(Integer roomNo);
    Room getRoomByNoS(Integer roomNo,Integer staffNo);
    void insertRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(Integer No);
}
