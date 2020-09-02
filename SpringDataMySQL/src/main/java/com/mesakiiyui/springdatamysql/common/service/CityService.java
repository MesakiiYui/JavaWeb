package com.mesakiiyui.springdatamysql.common.service;

import com.mesakiiyui.springdatamysql.common.entity.City;
import com.mesakiiyui.springdatamysql.common.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2020/8/14 10:12
 */

public interface CityService {

    public Page<City> findByPopulationOrderWithPageAble(Pageable pageable);
}
