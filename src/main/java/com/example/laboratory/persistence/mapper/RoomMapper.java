package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Room;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Select("select * from room where roomNo=#{No}")
    public Room getRoomByNo(Integer No);

    @Select("select * from room ")
    public List<Room> getAllRoom ();

    @Insert("insert into room(roomName,roomAddress,roomTtpe,roomState,roomAddDate)" +
            " values(#{roomName},#{roomAddress},#{roomType},#{roomState},#{roomAddDate}")
    public void insertRoom(Room room);

    @Update("update room set roomAddress = #{roomAddress},roomType = #{roomType},roomState = #{roomState} where roomNo = #{roomNo}")
    public void updateRoom(Room room);

    @Delete("delete from room where roomNo=#{No}")
    public void deleteRoom(Integer No);
}
