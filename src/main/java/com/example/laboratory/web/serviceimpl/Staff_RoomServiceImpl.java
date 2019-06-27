package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.common.model.Staff_Room;
import com.example.laboratory.persistence.mapper.StaffRoomMapper;
import com.example.laboratory.web.service.Staff_RoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Staff_RoomServiceImpl implements Staff_RoomService {
    @Autowired
    StaffRoomMapper staffRoomMapper;
    @Override
    public List<Staff_Room> getStaffRoomByStaffNo(Integer staffNo) {
        return staffRoomMapper.selectStaffRoomByStaffNo(staffNo);
    }

    @Override
    public List<Staff> getStaffRoomByRoomNo(Integer roomNo) {
        return staffRoomMapper.selectStaffRoomByRoomNo(roomNo);
    }

    @Override
    public void insertStaff(Integer staffNo, Integer roomNo) {
      staffRoomMapper.insertStaffRoom(staffNo,roomNo);
    }
}
