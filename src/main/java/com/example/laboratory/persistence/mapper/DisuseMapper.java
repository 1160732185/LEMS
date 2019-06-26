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
    public Disuse getDisuseByNoS(Integer disuseNo, Integer staffNo);

    @Select("select * from disuse where disuseNo=#{disuseNo}")
    public Disuse getDisuseByNo(Integer disuseNo);

    @Select("select * from disuse where staffNo=#{staffNo} limit #{firstRow},#{pageSize}")
    public List<Disuse> getAllDisuseS (Integer staffNo, Integer firstRow, Integer pageSize);

    @Select("select * from disuse limit #{firstRow},#{pageSize}")
    public List<Disuse> getAllDisuse (Integer firstRow,Integer pageSize);

    @Insert("insert into disuse(disuseNo,disuseStaffNo,disuseDate,disuseReason,disuseType,disuseState,disuseUpdateDate,disuseUpdateInfo)" +
            " values(#{disuseNo},#{disuseStaffNo},#{disuseDate},#{disuseReason},#{disuseType},#{disuseState},#{disuseUpdateDate},#{disuseUpdateInfo})")
    public void insertDisuse(Disuse disuse);

    @Update("update disuse set disuseReason = #{disuseReason},disuseType = #{disuseType} where disuseNo = #{disuseNo}")
    public void updateDisuseS(Disuse disuse);

    @Update("update disuse set checkStaffNo=#{checkStaffNo},disuseUpdateDate = #{disuseUpdateDate},disuseUpdateInfo = #{disuseUpdateInfo},disuseState = #{disuseState} where disuseNo = #{disuseNo}")
    public void updateDisuse(Disuse disuse);

    @Delete("delete from disuse where disuseNo=#{No}")
    public void deleteDisuse(Integer No);
}
