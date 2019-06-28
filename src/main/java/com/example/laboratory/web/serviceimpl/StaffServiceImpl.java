package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.persistence.mapper.StaffMapper;
import com.example.laboratory.web.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    public List<Staff> getAllStaff(Integer firstRow, Integer pageSize) {
        return staffMapper.getAllStaff(firstRow, pageSize);
    }

    @Override
    public Integer getStaffNoByStaffEmail(String staffEmail) {
        return staffMapper.getStaffNoByStaffEmail(staffEmail);
    }

    @Override
    public Staff getStaffByNo(Integer No) {
        return staffMapper.getStaffByNo(No);
    }

    @Override
    public void insertStaff(Staff staff) {
        staffMapper.insertStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffMapper.updateStaff(staff);
    }

    @Override
    public void deleteStaff(Integer No) {
        staffMapper.deleteStaff(No);
    }

    @Override
    public Integer getStaffCount() {
        return staffMapper.getStaffCount();
    }

}
