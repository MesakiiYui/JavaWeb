package com.mesakiiyui.springdatamysql.common.repo;

import com.mesakiiyui.springdatamysql.common.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

}
