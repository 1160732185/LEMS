package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Room;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Select("select r.roomNo,r.roomName,r.roomType,r.roomState,r.roomAddress,r.roomAddDate from room r,staff_room sr " +
            "where r.roomNo=sr.roomNo and r.roomNo=#{roomNo} and staffNo=#{staffNo}")
    public Room getRoomByNoS(Integer roomNo,Integer staffNo);

    @Select("select * from room where roomNo=#{roomNo}")
    public Room getRoomByNo(Integer roomNo);

    @Select("select r.roomNo,r.roomName,r.roomType,r.roomState,r.roomAddress,r.roomAddDate from room r,staff_room sr " +
            "where r.roomNo=sr.roomNo and staffNo=#{staffNo} limit #{firstRow},#{pageSize}")
    public List<Room> getAllRoomS (Integer staffNo,Integer firstRow,Integer pageSize);

    @Select("select * from room limit #{firstRow},#{pageSize}")
    public List<Room> getAllRoom (Integer firstRow,Integer pageSize);

    @Insert("insert into room(roomName,roomAddress,roomTtpe,roomState,roomAddDate)" +
            " values(#{roomName},#{roomAddress},#{roomType},#{roomState},#{roomAddDate})")
    public void insertRoom(Room room);

    @Update("update room set roomAddress = #{roomAddress},roomType = #{roomType},roomState = #{roomState} where roomNo = #{roomNo}")
    public void updateRoom(Room room);

    @Delete("delete from room where roomNo=#{No}")
    public void deleteRoom(Integer No);
}
