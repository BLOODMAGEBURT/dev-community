package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.FileRelationship;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:FileRelationship业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FileRelationshipService {

    /***
     * FileRelationship多条件分页查询
     * @param fileRelationship
     * @param page
     * @param size
     * @return
     */
    PageInfo<FileRelationship> findPage(FileRelationship fileRelationship, int page, int size);

    /***
     * FileRelationship分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<FileRelationship> findPage(int page, int size);

    /***
     * FileRelationship多条件搜索方法
     * @param fileRelationship
     * @return
     */
    List<FileRelationship> findList(FileRelationship fileRelationship);

    /***
     * 删除FileRelationship
     * @param id
     */
    void delete(Long id);

    /***
     * 修改FileRelationship数据
     * @param fileRelationship
     */
    void update(FileRelationship fileRelationship);

    /***
     * 新增FileRelationship
     * @param fileRelationship
     */
    void add(FileRelationship fileRelationship);

    /**
     * 根据ID查询FileRelationship
     * @param id
     * @return
     */
     FileRelationship findById(Long id);

    /***
     * 查询所有FileRelationship
     * @return
     */
    List<FileRelationship> findAll();
}
