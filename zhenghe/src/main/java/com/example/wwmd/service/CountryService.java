/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.wwmd.service;

import com.example.wwmd.dao.mapper.CountryMapper;
import com.example.wwmd.model.Country;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
@Service
public class CountryService {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

    @Autowired
    RedisTemplate redisTemplate;  //k- v 都是对象

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> getAll(Country country) {
        if (country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(), country.getRows());
        }
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (country.getCountryname() != null && country.getCountryname().length() > 0) {
            criteria.andLike("countryname", "%" + country.getCountryname() + "%");
        }
        if (country.getCountrycode() != null && country.getCountrycode().length() > 0) {
            criteria.andLike("countrycode", "%" + country.getCountrycode() + "%");
        }
        return countryMapper.selectByExample(example);
    }

    /**
     * 可以在Example.Criteria的条件方法里传 lambada
     *
     * @param country
     * @return
     */
    @Cacheable(cacheNames = "countries", key = "#country", unless = "#result == null")
    public List<Country> getAllByWeekend(Country country) {
        if (country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(), country.getRows());
        }
        Weekend<Country> weekend = Weekend.of(Country.class);
        WeekendCriteria<Country, Object> criteria = weekend.weekendCriteria();
        if (country.getCountryname() != null && country.getCountryname().length() > 0) {
            criteria.andLike(Country::getCountryname, "%" + country.getCountryname() + "%");
        }
        if (country.getCountrycode() != null && country.getCountrycode().length() > 0) {
            criteria.andLike(Country::getCountrycode, "%" + country.getCountrycode() + "%");
        }
        return countryMapper.selectByExample(weekend);
    }

    @Cacheable(cacheNames = "country", key = "#id")
    public Country getById(Integer id) {
        return countryMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        countryMapper.deleteByPrimaryKey(id);
    }

    public void save(Country country) {
        if (country.getId() != null) {
            countryMapper.updateByPrimaryKey(country);
        } else {
            countryMapper.insert(country);
        }
    }
}
