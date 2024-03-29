package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Apply;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyMapper {
    @Select("select count(*) from apply where applyStaffNo=#{staffNo}")
    public Integer getApplyCountS (Integer staffNo);

    @Select("select count(*) from apply")
    public Integer getApplyCount ();

    @Select("select count(*) from apply where applyType=#{applyType} and applyStaffNo=#{staffNo} and applyState='待审查' ")
    public  Integer getApplyByTypeCS(String applyType,Integer staffNo);

    @Select("select count(*) from apply where applyType=#{applyType} and applyState='待审查' ")
    public  Integer getApplyByTypeC(String applyType);

    @Select("select count(*) from apply where applyState=#{applyState} and applyStaffNo=#{staffNo} ")
    public  Integer getApplyByStateCS(String applyType,Integer staffNo);

    @Select("select count(*) from apply where applyState=#{applyState} ")
    public  Integer getApplyByStateC(String applyType);

    @Select("select * from apply where applyType=#{applyType} and applyStaffNo=#{staffNo}  and applyState='待审查' limit #{firstRow},#{pageSize}")
    public  List<Apply> getApplyByTypeS(String applyType,Integer staffNo,Integer firstRow,Integer pageSize);

    @Select("select * from apply where applyType=#{applyType} and applyState='待审查' limit #{firstRow},#{pageSize}")
    public  List<Apply> getApplyByType(String applyType,Integer firstRow,Integer pageSize);

    @Select("select * from apply where applyState=#{applyState} and applyStaffNo=#{staffNo} limit #{firstRow},#{pageSize}")
    public  List<Apply> getApplyByStateS(String applyState,Integer staffNo,Integer firstRow,Integer pageSize);

    @Select("select * from apply where applyState=#{applyState} limit #{firstRow},#{pageSize}")
    public  List<Apply> getApplyByState(String applyState,Integer firstRow,Integer pageSize);

    @Select("select * from apply where applyNo=#{applyNo} and applyStaffNo=#{staffNo}")
    public Apply getApplyByNoS(String applyNo,Integer staffNo);

    @Select("select * from apply where applyNo=#{applyNo}")
    public Apply getApplyByNo(String applyNo);

    @Select("select * from apply where applyStaffNo=#{staffNo} limit #{firstRow},#{pageSize}")
    public List<Apply> getAllApplyS (Integer staffNo,Integer firstRow,Integer pageSize);
//????
    @Select("select * from apply limit #{firstRow},#{pageSize}")
    public List<Apply> getAllApply (Integer firstRow,Integer pageSize);

    @Insert("insert into apply(applyNo,applyStaffNo,applyDate,applyReason,applyType,applyState,applyUpdateDate,applyUpdateInfo)" +
            " values(#{applyNo},#{applyStaffNo},#{applyDate},#{applyReason},#{applyType},#{applyState},#{applyUpdateDate},#{applyUpdateInfo})")
    public void insertApply(Apply apply);

    @Update("update apply set applyReason = #{applyReason},applyType = #{applyType} where applyNo = #{applyNo}")
    public void updateApplyS(Apply apply);

    @Update("update apply set checkStaffNo=#{checkStaffNo},applyUpdateDate = #{applyUpdateDate},applyUpdateInfo = #{applyUpdateInfo},applyState = #{applyState} where applyNo = #{applyNo}")
    public void updateApply(Apply apply);

    @Delete("delete from apply where applyNo=#{No}")
    public void deleteApply(String No);
}
