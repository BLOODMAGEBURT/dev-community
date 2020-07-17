package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.Blog;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Blog业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BlogService {

    /***
     * Blog多条件分页查询
     * @param blog
     * @param page
     * @param size
     * @return
     */
    PageInfo<Blog> findPage(Blog blog, int page, int size);

    /***
     * Blog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Blog> findPage(int page, int size);

    /***
     * Blog多条件搜索方法
     * @param blog
     * @return
     */
    List<Blog> findList(Blog blog);

    /***
     * 删除Blog
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Blog数据
     * @param blog
     */
    void update(Blog blog);

    /***
     * 新增Blog
     * @param blog
     */
    void add(Blog blog);

    /**
     * 根据ID查询Blog
     * @param id
     * @return
     */
     Blog findById(Long id);

    /***
     * 查询所有Blog
     * @return
     */
    List<Blog> findAll();
}
