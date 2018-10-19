package com.example.wwmd.dao.mapper;

import com.example.wwmd.model.Country;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface CountryMapper extends Mapper<Country> {
    @Select("select * from country where countryname = #{countryname}")
    Country selectByCountryName(String countryname);
}