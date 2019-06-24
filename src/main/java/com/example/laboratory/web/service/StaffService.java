package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Staff;
import io.swagger.models.auth.In;

import java.util.List;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff getStaffByNo(Integer No);
    void insertStaff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(Integer No);
}
