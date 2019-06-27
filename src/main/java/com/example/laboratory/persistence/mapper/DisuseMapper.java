package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Disuse;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface DisuseMapper {
    @Select("select count(*) from disuse where disuseStaffNo=#{staffNo}")
    public Integer getDisuseCountS (Integer staffNo);

    @Select("select count(*) from disuse")
    public Integer getDisuseCount ();

    @Select("select * from disuse where disuseNo=#{disuseNo} and staffNo=#{staffNo}")
    public Disuse getDisuseByNoS(String disuseNo, Integer staffNo);

    @Select("select * from disuse where disuseNo=#{disuseNo}")
    public Disuse getDisuseByNo(String disuseNo);

    @Select("select * from disuse where deviceNo=#{deviceNo} ORDER BY disuseDate DESC limit 1")
    public Disuse getDisuseByDeviceNo(String deviceNo);

    @Select("select * from disuse where staffNo=#{staffNo} limit #{firstRow},#{pageSize}")
    public List<Disuse> getAllDisuseS (Integer staffNo, Integer firstRow, Integer pageSize);

    @Select("select * from disuse limit #{firstRow},#{pageSize}")
    public List<Disuse> getAllDisuse (Integer firstRow,Integer pageSize);

    @Select("select count(*) from disuse where staffNo=#{staffNo} and disuseState = #{disuseState}")
    public Integer getAllDisuseByDisuseStateCS (Integer staffNo,String disuseState);

    @Select("select count(*) from disuse where disuseState=#{disuseState}")
    public Integer  getAllDisuseByDisuseStateC (String disuseState);

    @Select("select * from disuse where staffNo=#{staffNo} and disuseState = #{disuseState} limit #{firstRow},#{pageSize}")
    public List<Disuse> getAllDisuseByDisuseStateS (Integer staffNo,String disuseState ,Integer firstRow,Integer pageSize);

    @Select("select * from disuse where disuseState=#{disuseState} limit #{firstRow},#{pageSize}")
    public List<Disuse> getAllDisuseByDisuseState (Integer firstRow,String disuseState ,Integer pageSize);

    @Insert("insert into disuse(disuseNo,deviceNo,disuseStaffNo,disuseDate,disuseState,disuseUpdateDate)" +
            " values(#{disuseNo},#{deviceNo},#{disuseStaffNo},#{disuseDate},#{disuseState},#{disuseUpdateDate})")
    public void insertDisuse(Disuse disuse);

    @Update("")
    public void updateDisuseS(Disuse disuse);

    @Update("update disuse set checkStaffNo=#{checkStaffNo},disuseUpdateDate = #{disuseUpdateDate},disuseState = #{disuseState},disuseWay=#{disuseWay} where disuseNo = #{disuseNo}")
    public void updateDisuse(Disuse disuse);

    @Delete("delete from disuse where disuseNo=#{No}")
    public void deleteDisuse(String No);
}
