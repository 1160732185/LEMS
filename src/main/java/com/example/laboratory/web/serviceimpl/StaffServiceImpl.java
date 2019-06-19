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
}
