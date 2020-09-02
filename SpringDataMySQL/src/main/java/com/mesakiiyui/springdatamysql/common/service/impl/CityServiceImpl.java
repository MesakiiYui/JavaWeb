package com.mesakiiyui.springdatamysql.common.service.impl;

import com.mesakiiyui.springdatamysql.common.entity.City;
import com.mesakiiyui.springdatamysql.common.repo.CityRepository;
import com.mesakiiyui.springdatamysql.common.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: jintienan
 * @Date: 2020/8/14 13:48
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    public Page<City> findByPopulationOrderWithPageAble(Pageable pageable){
        Page<City> cityPage = cityRepository.findAllByOrderByPopulationDesc(pageable);
        return cityPage;
    }
}
