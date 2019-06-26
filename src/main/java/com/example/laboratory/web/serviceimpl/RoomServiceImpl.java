package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Room;
import com.example.laboratory.persistence.mapper.RoomMapper;
import com.example.laboratory.web.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public Integer getRoomCount() { return roomMapper.getRoomCount(); }
    @Override
    public Integer getRoomCountS(Integer staffNo) { return roomMapper.getRoomCountS(staffNo); }
    @Override
    public List<Room> getAllRoomS(Integer staffNo,Integer firstRow,Integer pageSize) { return roomMapper.getAllRoomS(staffNo,firstRow,pageSize); }
    public List<Room> getAllRoom(Integer firstRow,Integer pageSize) { return roomMapper.getAllRoom(firstRow,pageSize); }
    public Room getRoomByNoS(Integer roomNo,Integer staffNo) { return roomMapper.getRoomByNoS(roomNo,staffNo); }
    public Room getRoomByNo(Integer roomNo) { return roomMapper.getRoomByNo(roomNo); }
    public void insertRoom(Room room){roomMapper.insertRoom(room);}
    public void updateRoom(Room room) { roomMapper.updateRoom(room); }
    public void deleteRoom(Integer No) { roomMapper.deleteRoom(No); }
}
