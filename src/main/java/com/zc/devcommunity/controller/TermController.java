package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.Term;
import com.zc.devcommunity.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/term")
@CrossOrigin
public class TermController {

    @Autowired
    private TermService termService;

    /***
     * Term分页条件搜索实现
     * @param term
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Term term, @PathVariable  int page, @PathVariable  int size){
        //调用TermService实现分页条件查询Term
        PageInfo<Term> pageInfo = termService.findPage(term, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Term分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TermService实现分页查询Term
        PageInfo<Term> pageInfo = termService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param term
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Term>> findList(@RequestBody(required = false) Term term){
        //调用TermService实现条件查询Term
        List<Term> list = termService.findList(term);
        return new Result<List<Term>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用TermService实现根据主键删除
        termService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Term数据
     * @param term
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Term term, @PathVariable Long id){
        //设置主键值
        term.setId(id);
        //调用TermService实现修改Term
        termService.update(term);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Term数据
     * @param term
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Term term){
        //调用TermService实现添加Term
        termService.add(term);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Term数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Term> findById(@PathVariable Long id){
        //调用TermService实现根据主键查询Term
        Term term = termService.findById(id);
        return new Result<Term>(true,StatusCode.OK,"查询成功",term);
    }

    /***
     * 查询Term全部数据
     * @return
     */
    @GetMapping
    public Result<List<Term>> findAll(){
        //调用TermService实现查询所有Term
        List<Term> list = termService.findAll();
        return new Result<List<Term>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
