package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.DevDocHistory;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:DevDocHistory业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DevDocHistoryService {

    /***
     * DevDocHistory多条件分页查询
     * @param devDocHistory
     * @param page
     * @param size
     * @return
     */
    PageInfo<DevDocHistory> findPage(DevDocHistory devDocHistory, int page, int size);

    /***
     * DevDocHistory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<DevDocHistory> findPage(int page, int size);

    /***
     * DevDocHistory多条件搜索方法
     * @param devDocHistory
     * @return
     */
    List<DevDocHistory> findList(DevDocHistory devDocHistory);

    /***
     * 删除DevDocHistory
     * @param id
     */
    void delete(Long id);

    /***
     * 修改DevDocHistory数据
     * @param devDocHistory
     */
    void update(DevDocHistory devDocHistory);

    /***
     * 新增DevDocHistory
     * @param devDocHistory
     */
    void add(DevDocHistory devDocHistory);

    /**
     * 根据ID查询DevDocHistory
     * @param id
     * @return
     */
     DevDocHistory findById(Long id);

    /***
     * 查询所有DevDocHistory
     * @return
     */
    List<DevDocHistory> findAll();
}
