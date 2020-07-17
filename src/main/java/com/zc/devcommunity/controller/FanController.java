package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.Fan;
import com.zc.devcommunity.service.FanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/fan")
@CrossOrigin
public class FanController {

    @Autowired
    private FanService fanService;

    /***
     * Fan分页条件搜索实现
     * @param fan
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Fan fan, @PathVariable  int page, @PathVariable  int size){
        //调用FanService实现分页条件查询Fan
        PageInfo<Fan> pageInfo = fanService.findPage(fan, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Fan分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FanService实现分页查询Fan
        PageInfo<Fan> pageInfo = fanService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param fan
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Fan>> findList(@RequestBody(required = false) Fan fan){
        //调用FanService实现条件查询Fan
        List<Fan> list = fanService.findList(fan);
        return new Result<List<Fan>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用FanService实现根据主键删除
        fanService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Fan数据
     * @param fan
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Fan fan, @PathVariable Long id){
        //设置主键值
        fan.setId(id);
        //调用FanService实现修改Fan
        fanService.update(fan);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Fan数据
     * @param fan
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Fan fan){
        //调用FanService实现添加Fan
        fanService.add(fan);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Fan数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Fan> findById(@PathVariable Long id){
        //调用FanService实现根据主键查询Fan
        Fan fan = fanService.findById(id);
        return new Result<Fan>(true,StatusCode.OK,"查询成功",fan);
    }

    /***
     * 查询Fan全部数据
     * @return
     */
    @GetMapping
    public Result<List<Fan>> findAll(){
        //调用FanService实现查询所有Fan
        List<Fan> list = fanService.findAll();
        return new Result<List<Fan>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
