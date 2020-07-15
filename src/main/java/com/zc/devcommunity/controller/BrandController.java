package com.zc.devcommunity.controller;


import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.Brand;
import com.zc.devcommunity.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin //跨域
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有品牌
     */
    @GetMapping
    public Result<List<Brand>> findAll() {
        List<Brand> brands = brandService.findAll();

        //相应结果封装
        return new Result<>(true, StatusCode.OK, "查询品牌集合成功", brands);
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询品牌成功", brand);
    }

    @PostMapping
    public Result<Brand> add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK, "添加成功", brand);
    }

    /*
     * 根据条件查询
     * */
    @PostMapping("/search")
    public Result<Brand> findByCriteria(@RequestBody(required = false) Brand brand) {
        List<Brand> brands = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "条件查询成功", brands);
    }

    /*
     * 分页查询
     * */
    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {

        return new Result<>(true, StatusCode.OK, "分页查询成功", brandService.findPage(page, size));
    }

    /*
     * 分页条件查询
     * */
    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable int page, @PathVariable int size) {

        return new Result<>(true, StatusCode.OK, "分页条件查询成功", brandService.findPage(brand, page, size));
    }
}
