package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffMapper {
    @Select("select * from staff where staffNo=#{No}")
    public Staff getStaffByNo(Integer No);

    @Select("select * from staff")
    public List<Staff> getAllStaff();

    @Insert("insert into staff(staffName,staffSex,staffEmail,staffPassword,staffTelephone,staffDuty,staffRegisterTime)" +
            " values(#{staffName},#{staffSex},#{staffEmail},#{staffPassword},#{staffTelephone},#{staffDuty},#{staffRegisterTime})")
    public void insertStaff(Staff staff);

    @Update("update staff set staffEmail = #{staffEmail},staffPassword = #{staffPassword},staffTelephone = #{staffTelephone} where staffNo = #{staffNo}")
    public void updateStaff(Staff staff);

    @Delete("delete from staff where staffNo=#{No}")
    public void deleteStaff(Integer No);
}
