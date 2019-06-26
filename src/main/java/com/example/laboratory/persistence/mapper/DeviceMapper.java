package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Device;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {
    @Select("select count(*) from device d,staff_room sr " +
            "where d.roomNo=sr.roomNo and staffNo=#{staffNo}")
    public Integer getDeviceCountS (Integer staffNo);

    @Select("select count(*) from device")
    public Integer getDeviceCount ();

    @Select("select * from device where deviceNo=#{No}")
    public Device getDeviceByNo(String No);

    @Select("select * from device ")
    public List<Device> getAllDevice ();

    @Select("select deviceNo,d.staffNo,firmNo,modelNo,d.roomNo,deviceAddDate,deviceState from device d,staff_room sr " +
            "where d.roomNo=sr.roomNo and sr.staffNo=#{staffNo}")
    public List<Device> getAllDeviceS (Integer staffNo);

    @Insert("insert into device(deviceName,deviceType,deviceNorm,devicePrice)" +
            " values(#{deviceName},#{deviceType},#{deviceNorm},#{devicePrice})")
    public void insertDevice(Device device);

    @Update("update device set deviceName = #{deviceName},devicePrice = #{devicePrice},deviceType = #{deviceType},deviceNorm = #{deviceNorm} where deviceNo = #{deviceNo}")
    public void updateDevice(Device device);

    @Delete("delete from device where deviceNo=#{No}")
    public void deleteDevice(String No);
}
