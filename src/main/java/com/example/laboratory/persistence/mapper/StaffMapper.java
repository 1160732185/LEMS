package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffMapper {
    @Select("select * from staff where id=#{id}")
    public Staff getStaffById(String id);

    @Select("select * from staff")
    public List<Staff> getAllStaff();
}
