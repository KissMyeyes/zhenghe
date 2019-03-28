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

import com.example.wwmd.dao.mapper.CityMapper;
import com.example.wwmd.model.City;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
@Service
@CacheConfig(cacheNames = "city")
public class CityService {

    @Autowired
    private CityMapper cityMapper;


    /**
     * condition : 表示在哪种情况下才缓存结果
     * unless,哪种情况不缓存
     * 同样使用SpEL
     *
     * @param city
     * @return
     */
    @Cacheable(cacheNames = "city", key = "#{city.page+'_'+city.rows}", unless = "#result == null")
    public List<City> getAll(City city) {
        if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows());
        }
        return cityMapper.selectAll();
    }

    /**
     * cacheNames 设置缓存的值
     * key：指定缓存的key，这是指参数id值。 key可以使用spEl表达式
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "city", key = "#id", condition = "#id != 0")
    public City getById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    /**
     * @param id
     * @CachePut 方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中
     */
    @CacheEvict(cacheNames = "city", key = "#id", condition = "#id != 0") // 清空 city key 为id的缓存
    public void deleteById(Integer id) {
        cityMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(key = "#country.id", condition = "#country.id != null", allEntries = true)
    public void save(City country) {
        if (country.getId() != null) {
            cityMapper.updateByPrimaryKey(country);
        } else {
            cityMapper.insert(country);
        }
    }
}
