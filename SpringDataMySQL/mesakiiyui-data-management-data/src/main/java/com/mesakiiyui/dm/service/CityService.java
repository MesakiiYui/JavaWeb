package com.mesakiiyui.dm.service;

import com.mesakiiyui.springdatamysql.common.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: jintienan
 * @Date: 2020/8/14 10:12
 */

public interface CityService {

    public Page<City> findByPopulationOrderWithPageAble(Pageable pageable);
}
