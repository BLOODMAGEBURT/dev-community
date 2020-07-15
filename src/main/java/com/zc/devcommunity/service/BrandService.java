package com.zc.devcommunity.service;


import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     */
    List<Brand> findAll();

    /**
     * 根据ID查询实体数据
     */
    Brand findById(Integer id);

    /**
     * 添加品牌
     */
    void add(Brand brand);

    /*
    * 条件查询
    * */
    List<Brand> findList(Brand brand);

    /*
    * 分页查询
    * */
    PageInfo<Brand> findPage(int page, int size);

    /*
    * 条件分页查询
    * */
    PageInfo<Brand> findPage(Brand brand, int page, int size);
}
