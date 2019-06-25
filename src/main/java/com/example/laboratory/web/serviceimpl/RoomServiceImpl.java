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
    public List<Room> getAllRoom() { return roomMapper.getAllRoom(); }
    public Room getRoomByNo(Integer No) { return roomMapper.getRoomByNo(No); }
    public void insertRoom(Room room){roomMapper.insertRoom(room);}
    public void updateRoom(Room room) { roomMapper.updateRoom(room); }
    public void deleteRoom(Integer No) { roomMapper.deleteRoom(No); }
}
