package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Repair;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RepairMapper {
    @Select("select count(*) from repair where repairStaffNo=#{staffNo}")
    public Integer getRepairCountS (Integer staffNo);

    @Select("select count(*) from repair")
    public Integer getRepairCount ();

    @Select("select * from repair where repairNo=#{repairNo} and staffNo=#{staffNo}")
    public Repair getRepairByNoS(String repairNo, Integer staffNo);

    @Select("select * from repair where repairNo=#{repairNo}")
    public Repair getRepairByNo(String repairNo);

    @Select("select * from repair where deviceNo=#{deviceNo} ORDER BY repairDate desc limit 1")
    public Repair getRepairByDevice(String deviceNo);

    @Select("select * from repair where staffNo=#{staffNo} limit #{firstRow},#{pageSize}")
    public List<Repair> getAllRepairS (Integer staffNo, Integer firstRow, Integer pageSize);

    @Select("select * from repair limit #{firstRow},#{pageSize}")
    public List<Repair> getAllRepair (Integer firstRow,Integer pageSize);

    @Insert("insert into repair(repairNo,firmNo,repairFinishDate,deviceNo,staffNo,repairResult,repairPrice,repairDate)" +
            " values(#{repairNo},#{firmNo},#{repairFinishDate},#{deviceNo},#{staffNo},#{repairResult},#{repairPrice},#{repairDate})")
    public void insertRepair(Repair repair);

    @Update("update repair set repairFinishDate=#{repairFinishDate},repairResult = #{repairResult},repairPrice = #{repairPrice} where repairNo=#{repairNo}")
    public void updateRepair(Repair repair);

    @Delete("delete from repair where repairNo=#{No}")
    public void deleteRepair(String No);
}
