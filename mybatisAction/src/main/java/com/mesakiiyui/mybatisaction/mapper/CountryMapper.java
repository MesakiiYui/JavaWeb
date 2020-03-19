package com.mesakiiyui.mybatisaction.mapper;

import com.mesakiiyui.mybatisaction.model.Country;

import java.util.List;

public interface CountryMapper {
    /**
     * 查询全部用户
     *
     * @return
     */
    List<Country> selectAll();
}
