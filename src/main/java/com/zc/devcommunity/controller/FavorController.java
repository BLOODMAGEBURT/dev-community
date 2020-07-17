package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.Favor;
import com.zc.devcommunity.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/favor")
@CrossOrigin
public class FavorController {

    @Autowired
    private FavorService favorService;

    /***
     * Favor分页条件搜索实现
     * @param favor
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Favor favor, @PathVariable  int page, @PathVariable  int size){
        //调用FavorService实现分页条件查询Favor
        PageInfo<Favor> pageInfo = favorService.findPage(favor, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Favor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FavorService实现分页查询Favor
        PageInfo<Favor> pageInfo = favorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param favor
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Favor>> findList(@RequestBody(required = false) Favor favor){
        //调用FavorService实现条件查询Favor
        List<Favor> list = favorService.findList(favor);
        return new Result<List<Favor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用FavorService实现根据主键删除
        favorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Favor数据
     * @param favor
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Favor favor, @PathVariable Long id){
        //设置主键值
        favor.setId(id);
        //调用FavorService实现修改Favor
        favorService.update(favor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Favor数据
     * @param favor
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Favor favor){
        //调用FavorService实现添加Favor
        favorService.add(favor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Favor数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Favor> findById(@PathVariable Long id){
        //调用FavorService实现根据主键查询Favor
        Favor favor = favorService.findById(id);
        return new Result<Favor>(true,StatusCode.OK,"查询成功",favor);
    }

    /***
     * 查询Favor全部数据
     * @return
     */
    @GetMapping
    public Result<List<Favor>> findAll(){
        //调用FavorService实现查询所有Favor
        List<Favor> list = favorService.findAll();
        return new Result<List<Favor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
