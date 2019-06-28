package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffMapper {
    @Select("select count(staffNo) from staff")
    public  Integer getStaffCount();

    @Select("select staffNo from staff where staffEmail=#{staffEmail}")
    public  Integer getStaffNoByStaffEmail(String StaffEmail);

    @Select("select * from staff where staffNo=#{No}")
    public Staff getStaffByNo(Integer No);

    @Select("select * from staff limit #{firstRow},#{pageSize} ")
    public List<Staff> getAllStaff(Integer firstRow,Integer pageSize);

    @Insert("insert into staff(staffName,staffSex,staffEmail,staffPassword,staffTelephone,staffDuty,staffRegisterTime)" +
            " values(#{staffName},#{staffSex},#{staffEmail},#{staffPassword},#{staffTelephone},#{staffDuty},#{staffRegisterTime})")
    public void insertStaff(Staff staff);

    @Update("update staff set staffEmail = #{staffEmail},staffDuty = #{staffDuty},staffPassword = #{staffPassword},staffTelephone = #{staffTelephone} where staffNo = #{staffNo}")
    public void updateStaff(Staff staff);

    @Delete("delete from staff where staffNo=#{No}")
    public void deleteStaff(Integer No);

}
