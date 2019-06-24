package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.persistence.mapper.StaffMapper;
import com.example.laboratory.web.service.StaffService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaffServiceImpl implements StaffService {
@Autowired
StaffMapper staffMapper;
    @Override
    public List<Staff> getAllStaff() {
        return staffMapper.getAllStaff();
    }
    public Staff getStaffByNo(Integer No) {
        return staffMapper.getStaffByNo(No);
    }
    public void insertStaff(Staff staff){staffMapper.insertStaff(staff);}

    @Override
    public void updateStaff(Staff staff) {
        staffMapper.updateStaff(staff);
    }

    @Override
    public void deleteStaff(Integer No) {
        staffMapper.deleteStaff(No);
    }
}
