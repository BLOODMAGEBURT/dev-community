package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.BrandMapper;
import com.zc.devcommunity.pojo.Brand;
import com.zc.devcommunity.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service //加注解，给容器管理
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有
     */
    @Override
    public List<Brand> findAll() {
        // 查询所有-> Mapper.selectAll()
        return brandMapper.selectAll();

    }

    /**
     * 根据id查询品牌
     */
    @Override
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    /**
     * 添加品牌
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);

        return brandMapper.selectByExample(example);
    }


    private Example createExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            // 品牌名称
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            // 品牌图片地址
            if (!StringUtils.isEmpty(brand.getImage())) {
                criteria.andLike("image", "%" + brand.getImage() + "%");
            }
            // 品牌的首字母
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andLike("letter", "%" + brand.getLetter() + "%");
            }
            // 品牌id
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("id", brand.getId());
            }
            // 排序
            if (!StringUtils.isEmpty(brand.getSeq())) {
                criteria.andEqualTo("seq", brand.getSeq());
            }
        }
        return example;
    }

    /*
     * 分页查询
     * */
    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);

        //分页查询
        return new PageInfo<>(brandMapper.selectAll());
    }

    /*
     * 分页条件查询
     * */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        PageHelper.startPage(page, size);

        // 条件
        Example example = createExample(brand);

        return new PageInfo<>(brandMapper.selectByExample(example));
    }

}
