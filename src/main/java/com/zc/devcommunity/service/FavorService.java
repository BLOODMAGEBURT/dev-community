package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.Favor;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Favor业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FavorService {

    /***
     * Favor多条件分页查询
     * @param favor
     * @param page
     * @param size
     * @return
     */
    PageInfo<Favor> findPage(Favor favor, int page, int size);

    /***
     * Favor分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Favor> findPage(int page, int size);

    /***
     * Favor多条件搜索方法
     * @param favor
     * @return
     */
    List<Favor> findList(Favor favor);

    /***
     * 删除Favor
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Favor数据
     * @param favor
     */
    void update(Favor favor);

    /***
     * 新增Favor
     * @param favor
     */
    void add(Favor favor);

    /**
     * 根据ID查询Favor
     * @param id
     * @return
     */
     Favor findById(Long id);

    /***
     * 查询所有Favor
     * @return
     */
    List<Favor> findAll();
}
