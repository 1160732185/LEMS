package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Model;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModelMapper {
    @Select("select count(*) from model")
    public  Integer getModelCount();

    @Select("select * from model where modelNo=#{No}")
    public Model getModelByNo(String No);

    @Select("select * from model  limit #{firstRow},#{pageSize} ")
    public List<Model> getAllModel (Integer firstRow,Integer pageSize);

    @Select("select modelNo from model ")
    public List<String> getAllModelNo ();

    @Insert("insert into model(modelNo,modelName,modelType,modelNorm,modelPrice)" +
            " values(#{modelNo},#{modelName},#{modelType},#{modelNorm},#{modelPrice})")
    public void insertModel(Model model);

    @Update("update model set modelPrice = #{modelPrice},modelType = #{modelType},modelNorm = #{modelNorm} where modelNo = #{modelNo}")
    public void updateModel(Model model);

    @Delete("delete from model where modelNo=#{No}")
    public void deleteModel(String No);
}
