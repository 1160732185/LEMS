package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Staff_Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffRoomMapper {
    @Insert("insert into staff_room values(#{staffNo},#{roomNo})")
    void insertStaffRoom(Integer staffNo,Integer roomNo);

    @Select("select * from staff_room where staffNo = #{staffNo}")
    List<Staff_Room> selectStaffRoomByStaffNo(Integer staffNo);

    @Select("select * from staff_room where roomNo = #{roomNo}")
    List<Staff_Room> selectStaffRoomByRoomNo(Integer roomNo);
}
