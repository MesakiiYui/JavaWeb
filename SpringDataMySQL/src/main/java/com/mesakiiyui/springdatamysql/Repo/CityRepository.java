package com.mesakiiyui.springdatamysql.Repo;

import com.mesakiiyui.springdatamysql.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

}
