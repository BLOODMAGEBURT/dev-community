package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.Model;
import com.zc.devcommunity.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/model")
@CrossOrigin
public class ModelController {

    @Autowired
    private ModelService modelService;

    /***
     * Model分页条件搜索实现
     * @param model
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Model model, @PathVariable  int page, @PathVariable  int size){
        //调用ModelService实现分页条件查询Model
        PageInfo<Model> pageInfo = modelService.findPage(model, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Model分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ModelService实现分页查询Model
        PageInfo<Model> pageInfo = modelService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param model
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Model>> findList(@RequestBody(required = false) Model model){
        //调用ModelService实现条件查询Model
        List<Model> list = modelService.findList(model);
        return new Result<List<Model>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用ModelService实现根据主键删除
        modelService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Model数据
     * @param model
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Model model, @PathVariable Long id){
        //设置主键值
        model.setId(id);
        //调用ModelService实现修改Model
        modelService.update(model);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Model数据
     * @param model
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Model model){
        //调用ModelService实现添加Model
        modelService.add(model);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Model数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Model> findById(@PathVariable Long id){
        //调用ModelService实现根据主键查询Model
        Model model = modelService.findById(id);
        return new Result<Model>(true,StatusCode.OK,"查询成功",model);
    }

    /***
     * 查询Model全部数据
     * @return
     */
    @GetMapping
    public Result<List<Model>> findAll(){
        //调用ModelService实现查询所有Model
        List<Model> list = modelService.findAll();
        return new Result<List<Model>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
