package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.common.model.Staff_Room;

import java.util.List;

public interface Staff_RoomService {
    List<Staff_Room> getStaffRoomByStaffNo(Integer staffNo);

    List<Staff> getStaffRoomByRoomNo(Integer roomNo);

    void insertStaff(Integer staffNo,Integer roomNo);
}
