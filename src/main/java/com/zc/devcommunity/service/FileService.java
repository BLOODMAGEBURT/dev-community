package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.File;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:File业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FileService {

    /***
     * File多条件分页查询
     * @param file
     * @param page
     * @param size
     * @return
     */
    PageInfo<File> findPage(File file, int page, int size);

    /***
     * File分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<File> findPage(int page, int size);

    /***
     * File多条件搜索方法
     * @param file
     * @return
     */
    List<File> findList(File file);

    /***
     * 删除File
     * @param id
     */
    void delete(Long id);

    /***
     * 修改File数据
     * @param file
     */
    void update(File file);

    /***
     * 新增File
     * @param file
     */
    void add(File file);

    /**
     * 根据ID查询File
     * @param id
     * @return
     */
     File findById(Long id);

    /***
     * 查询所有File
     * @return
     */
    List<File> findAll();
}
