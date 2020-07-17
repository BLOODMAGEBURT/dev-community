package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.File;
import com.zc.devcommunity.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Autowired
    private FileService fileService;

    /***
     * File分页条件搜索实现
     * @param file
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) File file, @PathVariable  int page, @PathVariable  int size){
        //调用FileService实现分页条件查询File
        PageInfo<File> pageInfo = fileService.findPage(file, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * File分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FileService实现分页查询File
        PageInfo<File> pageInfo = fileService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param file
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<File>> findList(@RequestBody(required = false) File file){
        //调用FileService实现条件查询File
        List<File> list = fileService.findList(file);
        return new Result<List<File>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用FileService实现根据主键删除
        fileService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改File数据
     * @param file
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody File file, @PathVariable Long id){
        //设置主键值
        file.setId(id);
        //调用FileService实现修改File
        fileService.update(file);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增File数据
     * @param file
     * @return
     */
    @PostMapping
    public Result add(@RequestBody File file){
        //调用FileService实现添加File
        fileService.add(file);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询File数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<File> findById(@PathVariable Long id){
        //调用FileService实现根据主键查询File
        File file = fileService.findById(id);
        return new Result<File>(true,StatusCode.OK,"查询成功",file);
    }

    /***
     * 查询File全部数据
     * @return
     */
    @GetMapping
    public Result<List<File>> findAll(){
        //调用FileService实现查询所有File
        List<File> list = fileService.findAll();
        return new Result<List<File>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
