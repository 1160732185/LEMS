package com.example.laboratory.persistence.mapper;

import com.example.laboratory.common.model.Model;
import com.example.laboratory.common.model.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModelMapper {
    @Select("select * from model where modelNo=#{No}")
    public Model getModelByNo(String No);

    @Select("select * from model ")
    public List<Model> getAllModel ();

    @Insert("insert into model(modelName,modelTtpe,modelNorm,modelPrice)" +
            " values(#{modelName},#{modelType},#{modelNorm},#{modelPrice}")
    public void insertModel(Model model);

    @Update("update model set modelName = #{modelName},modelPrice = #{modelPrice},modelType = #{modelType},modelNorm = #{modelNorm} where modelNo = #{modelNo}")
    public void updateModel(Model model);

    @Delete("delete from model where modelNo=#{No}")
    public void deleteModel(String No);
}
