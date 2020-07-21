package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.IdWorker;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.*;
import com.zc.devcommunity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private FileRelationshipService fileRelationshipService;

    @Autowired
    private TermRelationshipService termRelationshipService;

    /***
     * Blog分页条件搜索实现
     * @param blog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Blog blog, @PathVariable int page, @PathVariable int size) {
        //调用BlogService实现分页条件查询Blog
        PageInfo<Blog> pageInfo = blogService.findPage(blog, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * Blog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用BlogService实现分页查询Blog
        PageInfo<Blog> pageInfo = blogService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param blog
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Blog>> findList(@RequestBody(required = false) Blog blog) {
        //调用BlogService实现条件查询Blog
        List<Blog> list = blogService.findList(blog);
        return new Result<List<Blog>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用BlogService实现根据主键删除
        blogService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改Blog数据
     * @param blog
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Blog blog, @PathVariable Long id) {
        //设置主键值
        blog.setId(id);
        //调用BlogService实现修改Blog
        blogService.update(blog);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增Blog数据
     * @param blogWithTypeAndFile
     * @return
     */
    @PostMapping
    public Result add(@RequestBody BlogWithTypeAndFile blogWithTypeAndFile) {

        blogService.saveBlogWithTypeAndFile(blogWithTypeAndFile);

        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 根据ID查询Blog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Blog> findById(@PathVariable Long id) {
        //调用BlogService实现根据主键查询Blog
        Blog blog = blogService.findById(id);
        return new Result<Blog>(true, StatusCode.OK, "查询成功", blog);
    }

    /***
     * 查询Blog全部数据
     * @return
     */
    @GetMapping
    public Result<List<Blog>> findAll() {
        //调用BlogService实现查询所有Blog
        List<Blog> list = blogService.findAll();
        return new Result<List<Blog>>(true, StatusCode.OK, "查询成功", list);
    }
}
