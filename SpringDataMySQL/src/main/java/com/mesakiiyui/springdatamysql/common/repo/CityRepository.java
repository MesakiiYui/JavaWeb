package com.mesakiiyui.springdatamysql.common.repo;

import com.mesakiiyui.springdatamysql.common.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByName(String name);

    List<City> findByNameAndId(String name, Integer id);

    List<City> findByNameOrId(String name, Integer id);

    Page<City> findAllByOrderByPopulationDesc(Pageable pageable);

    List<City> findFirst10ByPopulationGreaterThanOrderByPopulationDesc(Integer basePopulation);

//    // 此处使用的是query,走参数索引
//    @Query("select c from city c where c.district = ?1")
//    List<City> findByDistrict(String district);


}
