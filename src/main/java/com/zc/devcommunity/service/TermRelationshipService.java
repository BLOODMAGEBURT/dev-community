package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.TermRelationship;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:TermRelationship业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TermRelationshipService {

    /***
     * TermRelationship多条件分页查询
     * @param termRelationship
     * @param page
     * @param size
     * @return
     */
    PageInfo<TermRelationship> findPage(TermRelationship termRelationship, int page, int size);

    /***
     * TermRelationship分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<TermRelationship> findPage(int page, int size);

    /***
     * TermRelationship多条件搜索方法
     * @param termRelationship
     * @return
     */
    List<TermRelationship> findList(TermRelationship termRelationship);

    /***
     * 删除TermRelationship
     * @param id
     */
    void delete(Long id);

    /***
     * 修改TermRelationship数据
     * @param termRelationship
     */
    void update(TermRelationship termRelationship);

    /***
     * 新增TermRelationship
     * @param termRelationship
     */
    void add(TermRelationship termRelationship);

    /**
     * 根据ID查询TermRelationship
     * @param id
     * @return
     */
     TermRelationship findById(Long id);

    /***
     * 查询所有TermRelationship
     * @return
     */
    List<TermRelationship> findAll();
}
