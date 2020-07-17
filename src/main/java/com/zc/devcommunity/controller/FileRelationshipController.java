package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.FileRelationship;
import com.zc.devcommunity.service.FileRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/fileRelationship")
@CrossOrigin
public class FileRelationshipController {

    @Autowired
    private FileRelationshipService fileRelationshipService;

    /***
     * FileRelationship分页条件搜索实现
     * @param fileRelationship
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) FileRelationship fileRelationship, @PathVariable  int page, @PathVariable  int size){
        //调用FileRelationshipService实现分页条件查询FileRelationship
        PageInfo<FileRelationship> pageInfo = fileRelationshipService.findPage(fileRelationship, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * FileRelationship分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FileRelationshipService实现分页查询FileRelationship
        PageInfo<FileRelationship> pageInfo = fileRelationshipService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param fileRelationship
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<FileRelationship>> findList(@RequestBody(required = false) FileRelationship fileRelationship){
        //调用FileRelationshipService实现条件查询FileRelationship
        List<FileRelationship> list = fileRelationshipService.findList(fileRelationship);
        return new Result<List<FileRelationship>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用FileRelationshipService实现根据主键删除
        fileRelationshipService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改FileRelationship数据
     * @param fileRelationship
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody FileRelationship fileRelationship, @PathVariable Long id){
        //设置主键值
        fileRelationship.setId(id);
        //调用FileRelationshipService实现修改FileRelationship
        fileRelationshipService.update(fileRelationship);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增FileRelationship数据
     * @param fileRelationship
     * @return
     */
    @PostMapping
    public Result add(@RequestBody FileRelationship fileRelationship){
        //调用FileRelationshipService实现添加FileRelationship
        fileRelationshipService.add(fileRelationship);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询FileRelationship数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<FileRelationship> findById(@PathVariable Long id){
        //调用FileRelationshipService实现根据主键查询FileRelationship
        FileRelationship fileRelationship = fileRelationshipService.findById(id);
        return new Result<FileRelationship>(true,StatusCode.OK,"查询成功",fileRelationship);
    }

    /***
     * 查询FileRelationship全部数据
     * @return
     */
    @GetMapping
    public Result<List<FileRelationship>> findAll(){
        //调用FileRelationshipService实现查询所有FileRelationship
        List<FileRelationship> list = fileRelationshipService.findAll();
        return new Result<List<FileRelationship>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
