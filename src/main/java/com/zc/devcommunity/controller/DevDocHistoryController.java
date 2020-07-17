package com.zc.devcommunity.controller;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.DevDocHistory;
import com.zc.devcommunity.service.DevDocHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/devDocHistory")
@CrossOrigin
public class DevDocHistoryController {

    @Autowired
    private DevDocHistoryService devDocHistoryService;

    /***
     * DevDocHistory分页条件搜索实现
     * @param devDocHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) DevDocHistory devDocHistory, @PathVariable int page, @PathVariable int size) {
        //调用DevDocHistoryService实现分页条件查询DevDocHistory
        PageInfo<DevDocHistory> pageInfo = devDocHistoryService.findPage(devDocHistory, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * DevDocHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用DevDocHistoryService实现分页查询DevDocHistory
        PageInfo<DevDocHistory> pageInfo = devDocHistoryService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param devDocHistory
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<DevDocHistory>> findList(@RequestBody(required = false) DevDocHistory devDocHistory) {
        //调用DevDocHistoryService实现条件查询DevDocHistory
        List<DevDocHistory> list = devDocHistoryService.findList(devDocHistory);
        return new Result<List<DevDocHistory>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用DevDocHistoryService实现根据主键删除
        devDocHistoryService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改DevDocHistory数据
     * @param devDocHistory
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody DevDocHistory devDocHistory, @PathVariable Long id) {
        //设置主键值
        devDocHistory.setId(id);
        //调用DevDocHistoryService实现修改DevDocHistory
        devDocHistoryService.update(devDocHistory);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增DevDocHistory数据
     * @param devDocHistory
     * @return
     */
    @PostMapping
    public Result add(@RequestBody DevDocHistory devDocHistory) {
        //调用DevDocHistoryService实现添加DevDocHistory
        devDocHistoryService.add(devDocHistory);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 根据ID查询DevDocHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DevDocHistory> findById(@PathVariable Long id) {
        //调用DevDocHistoryService实现根据主键查询DevDocHistory
        DevDocHistory devDocHistory = devDocHistoryService.findById(id);
        return new Result<DevDocHistory>(true, StatusCode.OK, "查询成功", devDocHistory);
    }

    /***
     * 查询DevDocHistory全部数据
     * @return
     */
    @GetMapping
    public Result<List<DevDocHistory>> findAll() {
        //调用DevDocHistoryService实现查询所有DevDocHistory
        List<DevDocHistory> list = devDocHistoryService.findAll();
        return new Result<List<DevDocHistory>>(true, StatusCode.OK, "查询成功", list);
    }
}
