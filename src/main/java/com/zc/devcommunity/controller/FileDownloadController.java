package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.FileDownload;
import com.zc.devcommunity.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/fileDownload")
@CrossOrigin
public class FileDownloadController {

    @Autowired
    private FileDownloadService fileDownloadService;

    /***
     * FileDownload分页条件搜索实现
     * @param fileDownload
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) FileDownload fileDownload, @PathVariable  int page, @PathVariable  int size){
        //调用FileDownloadService实现分页条件查询FileDownload
        PageInfo<FileDownload> pageInfo = fileDownloadService.findPage(fileDownload, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * FileDownload分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FileDownloadService实现分页查询FileDownload
        PageInfo<FileDownload> pageInfo = fileDownloadService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param fileDownload
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<FileDownload>> findList(@RequestBody(required = false) FileDownload fileDownload){
        //调用FileDownloadService实现条件查询FileDownload
        List<FileDownload> list = fileDownloadService.findList(fileDownload);
        return new Result<List<FileDownload>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用FileDownloadService实现根据主键删除
        fileDownloadService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改FileDownload数据
     * @param fileDownload
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody FileDownload fileDownload, @PathVariable Long id){
        //设置主键值
        fileDownload.setId(id);
        //调用FileDownloadService实现修改FileDownload
        fileDownloadService.update(fileDownload);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增FileDownload数据
     * @param fileDownload
     * @return
     */
    @PostMapping
    public Result add(@RequestBody FileDownload fileDownload){
        //调用FileDownloadService实现添加FileDownload
        fileDownloadService.add(fileDownload);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询FileDownload数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<FileDownload> findById(@PathVariable Long id){
        //调用FileDownloadService实现根据主键查询FileDownload
        FileDownload fileDownload = fileDownloadService.findById(id);
        return new Result<FileDownload>(true,StatusCode.OK,"查询成功",fileDownload);
    }

    /***
     * 查询FileDownload全部数据
     * @return
     */
    @GetMapping
    public Result<List<FileDownload>> findAll(){
        //调用FileDownloadService实现查询所有FileDownload
        List<FileDownload> list = fileDownloadService.findAll();
        return new Result<List<FileDownload>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
