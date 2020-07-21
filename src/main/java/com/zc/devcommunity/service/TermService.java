package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.pojo.Term;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Term业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TermService {

    /***
     * Term多条件分页查询
     * @param term
     * @param page
     * @param size
     * @return
     */
    PageInfo<Term> findPage(Term term, int page, int size);

    /***
     * Term分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Term> findPage(int page, int size);

    /***
     * Term多条件搜索方法
     * @param term
     * @return
     */
    List<Term> findList(Term term);

    /***
     * 删除Term
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Term数据
     * @param term
     */
    void update(Term term);

    /***
     * 新增Term
     * @param term
     */
    void add(Term term);

    /**
     * 根据ID查询Term
     * @param id
     * @return
     */
     Term findById(Long id);

    /***
     * 查询所有Term
     * @return
     */
    List<Term> findAll();

}
