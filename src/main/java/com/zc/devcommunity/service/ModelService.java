package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.Model;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Model业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ModelService {

    /***
     * Model多条件分页查询
     * @param model
     * @param page
     * @param size
     * @return
     */
    PageInfo<Model> findPage(Model model, int page, int size);

    /***
     * Model分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Model> findPage(int page, int size);

    /***
     * Model多条件搜索方法
     * @param model
     * @return
     */
    List<Model> findList(Model model);

    /***
     * 删除Model
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Model数据
     * @param model
     */
    void update(Model model);

    /***
     * 新增Model
     * @param model
     */
    void add(Model model);

    /**
     * 根据ID查询Model
     * @param id
     * @return
     */
     Model findById(Long id);

    /***
     * 查询所有Model
     * @return
     */
    List<Model> findAll();
}
