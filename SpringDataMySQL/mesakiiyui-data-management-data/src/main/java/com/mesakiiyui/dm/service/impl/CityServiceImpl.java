package com.mesakiiyui.dm.service.impl;

import com.mesakiiyui.dm.entity.City;
import com.mesakiiyui.dm.service.CityService;
import com.mesakiiyui.dm.repo.CityRepository;
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
