package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.DevDoc;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:DevDoc业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DevDocService {

    /***
     * DevDoc多条件分页查询
     * @param devDoc
     * @param page
     * @param size
     * @return
     */
    PageInfo<DevDoc> findPage(DevDoc devDoc, int page, int size);

    /***
     * DevDoc分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<DevDoc> findPage(int page, int size);

    /***
     * DevDoc多条件搜索方法
     * @param devDoc
     * @return
     */
    List<DevDoc> findList(DevDoc devDoc);

    /***
     * 删除DevDoc
     * @param id
     */
    void delete(Long id);

    /***
     * 修改DevDoc数据
     * @param devDoc
     */
    void update(DevDoc devDoc);

    /***
     * 新增DevDoc
     * @param devDoc
     */
    void add(DevDoc devDoc);

    /**
     * 根据ID查询DevDoc
     * @param id
     * @return
     */
     DevDoc findById(Long id);

    /***
     * 查询所有DevDoc
     * @return
     */
    List<DevDoc> findAll();
}
