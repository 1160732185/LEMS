package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getAllStaff(Integer firstRow, Integer pageSize);

    Integer getStaffNoByStaffEmail(String staffEmail);

    Staff getStaffByNo(Integer No);

    void insertStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(Integer No);

    Integer getStaffCount();

}
