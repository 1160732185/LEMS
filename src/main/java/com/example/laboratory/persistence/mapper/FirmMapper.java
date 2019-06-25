package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Firm;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FirmMapper {
    @Select("select count(*) from firm")
    public  Integer getFirmCount();

    @Select("select * from firm where firmNo=#{No}")
    public Firm getFirmByNo(Integer No);

    @Select("select * from firm limit #{firstRow},#{pageSize} ")
    public List<Firm> getAllFirm(Integer firstRow,Integer pageSize);

    @Insert("insert into firm(firmName,firmAddress,firmContacter,firmTelephone,firmEmail,firmAddDate)" +
            " values(#{firmName},#{firmAddress},#{firmContacter},#{firmTelephone},#{firmEmail},#{firmAddDate})")
    public void insertFirm(Firm firm);

    @Update("update firm set firmAddress = #{firmAddress},firmContacter = #{firmContacter},firmTelephone = #{firmTelephone},firmEmail = #{firmEmail} where firmNo = #{firmNo}")
    public void updateFirm(Firm firm);

    @Delete("delete from firm where firmNo=#{No}")
    public void deleteFirm(Integer No);
}
