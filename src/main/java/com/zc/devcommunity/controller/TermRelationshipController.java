package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.TermRelationship;
import com.zc.devcommunity.service.TermRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/termRelationship")
@CrossOrigin
public class TermRelationshipController {

    @Autowired
    private TermRelationshipService termRelationshipService;

    /***
     * TermRelationship分页条件搜索实现
     * @param termRelationship
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) TermRelationship termRelationship, @PathVariable  int page, @PathVariable  int size){
        //调用TermRelationshipService实现分页条件查询TermRelationship
        PageInfo<TermRelationship> pageInfo = termRelationshipService.findPage(termRelationship, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * TermRelationship分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TermRelationshipService实现分页查询TermRelationship
        PageInfo<TermRelationship> pageInfo = termRelationshipService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param termRelationship
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<TermRelationship>> findList(@RequestBody(required = false) TermRelationship termRelationship){
        //调用TermRelationshipService实现条件查询TermRelationship
        List<TermRelationship> list = termRelationshipService.findList(termRelationship);
        return new Result<List<TermRelationship>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用TermRelationshipService实现根据主键删除
        termRelationshipService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改TermRelationship数据
     * @param termRelationship
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody TermRelationship termRelationship, @PathVariable Long id){
        //设置主键值
        termRelationship.setId(id);
        //调用TermRelationshipService实现修改TermRelationship
        termRelationshipService.update(termRelationship);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增TermRelationship数据
     * @param termRelationship
     * @return
     */
    @PostMapping
    public Result add(@RequestBody TermRelationship termRelationship){
        //调用TermRelationshipService实现添加TermRelationship
        termRelationshipService.add(termRelationship);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询TermRelationship数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<TermRelationship> findById(@PathVariable Long id){
        //调用TermRelationshipService实现根据主键查询TermRelationship
        TermRelationship termRelationship = termRelationshipService.findById(id);
        return new Result<TermRelationship>(true,StatusCode.OK,"查询成功",termRelationship);
    }

    /***
     * 查询TermRelationship全部数据
     * @return
     */
    @GetMapping
    public Result<List<TermRelationship>> findAll(){
        //调用TermRelationshipService实现查询所有TermRelationship
        List<TermRelationship> list = termRelationshipService.findAll();
        return new Result<List<TermRelationship>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
