package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.ApplyDetail;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface ApplyDetailMapper {
    @Select("select count(*) from applydetail where applyNo=#{applyNo}")
    public Integer getApplyDetailCountByApplyNo (String applyNo);

    @Select("select * from applydetail where applyNo=#{applyNo} limit #{firstRow},#{pageSize}")
    public List<ApplyDetail> getAllApplyDetailByApplyNo (String applyNo,Integer firstRow,Integer pageSize);

    @Insert("insert into applydetail(modelNo,applyNo,applyDetailQuantity,applyDetailUnit)" +
            " values(#{modelNo},#{applyNo},#{applyDetailQuantity},#{applyDetailUnit})")
    public void insertApplyDetail(ApplyDetail applydetail);

    @Update("update applydetail set applyDetailQuantity = #{applyDetailQuantity}, applyDetailUnit=#{applyDetailUnit}" +
            "where  modelNo = #{modelNo} and applyNo = #{applyNo},")
    public void updateApplyDetail(ApplyDetail applydetail);

    @Delete("delete from applydetail where  modelNo = #{modelNo} and applyNo = #{applyNo}")
    public void deleteApplyDetail(String applyNo,String modelNo);
}
