package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.DevDoc;
import com.zc.devcommunity.service.DevDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/devDoc")
@CrossOrigin
public class DevDocController {

    @Autowired
    private DevDocService devDocService;

    /***
     * DevDoc分页条件搜索实现
     * @param devDoc
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) DevDoc devDoc, @PathVariable  int page, @PathVariable  int size){
        //调用DevDocService实现分页条件查询DevDoc
        PageInfo<DevDoc> pageInfo = devDocService.findPage(devDoc, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * DevDoc分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DevDocService实现分页查询DevDoc
        PageInfo<DevDoc> pageInfo = devDocService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param devDoc
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<DevDoc>> findList(@RequestBody(required = false) DevDoc devDoc){
        //调用DevDocService实现条件查询DevDoc
        List<DevDoc> list = devDocService.findList(devDoc);
        return new Result<List<DevDoc>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用DevDocService实现根据主键删除
        devDocService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改DevDoc数据
     * @param devDoc
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody DevDoc devDoc, @PathVariable Long id){
        //设置主键值
        devDoc.setId(id);
        //调用DevDocService实现修改DevDoc
        devDocService.update(devDoc);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增DevDoc数据
     * @param devDoc
     * @return
     */
    @PostMapping
    public Result add(@RequestBody DevDoc devDoc){
        //调用DevDocService实现添加DevDoc
        devDocService.add(devDoc);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询DevDoc数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DevDoc> findById(@PathVariable Long id){
        //调用DevDocService实现根据主键查询DevDoc
        DevDoc devDoc = devDocService.findById(id);
        return new Result<DevDoc>(true,StatusCode.OK,"查询成功",devDoc);
    }

    /***
     * 查询DevDoc全部数据
     * @return
     */
    @GetMapping
    public Result<List<DevDoc>> findAll(){
        //调用DevDocService实现查询所有DevDoc
        List<DevDoc> list = devDocService.findAll();
        return new Result<List<DevDoc>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
