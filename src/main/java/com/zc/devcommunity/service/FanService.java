package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.Fan;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Fan业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FanService {

    /***
     * Fan多条件分页查询
     * @param fan
     * @param page
     * @param size
     * @return
     */
    PageInfo<Fan> findPage(Fan fan, int page, int size);

    /***
     * Fan分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Fan> findPage(int page, int size);

    /***
     * Fan多条件搜索方法
     * @param fan
     * @return
     */
    List<Fan> findList(Fan fan);

    /***
     * 删除Fan
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Fan数据
     * @param fan
     */
    void update(Fan fan);

    /***
     * 新增Fan
     * @param fan
     */
    void add(Fan fan);

    /**
     * 根据ID查询Fan
     * @param id
     * @return
     */
     Fan findById(Long id);

    /***
     * 查询所有Fan
     * @return
     */
    List<Fan> findAll();
}
