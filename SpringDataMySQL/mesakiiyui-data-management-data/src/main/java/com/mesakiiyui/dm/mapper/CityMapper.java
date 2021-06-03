package com.mesakiiyui.dm.mapper;

import com.mesakiiyui.dm.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author: jintienan
 * @Date: 2021/6/3 16:31
 */
@Mapper
public interface CityMapper {

    /**
     * 使用@Param
     * @param id
     * @return
     */
    @Select("SELECT * FROM CITY WHERE ID = #{id}")
    City findById(@Param("id") Integer id);

    /**
     * 使用Map
     * @param map
     * @return
     */
    @Select("SELECT * from  CITY where id = #{id,jdbcType=INTEGER} and name = #{name,jdbcType=INTEGER}")
    City findByIdName(Map<String, Object> map);



//    @Insert("INSERT INTO City(NAME, AGE) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);

}
