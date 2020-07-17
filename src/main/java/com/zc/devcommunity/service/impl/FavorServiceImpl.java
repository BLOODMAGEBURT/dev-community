package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.FavorMapper;
import com.zc.devcommunity.pojo.Favor;
import com.zc.devcommunity.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Favor业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FavorServiceImpl implements FavorService {

    @Autowired
    private FavorMapper favorMapper;


    /**
     * Favor条件+分页查询
     * @param favor 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Favor> findPage(Favor favor, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(favor);
        //执行搜索
        return new PageInfo<Favor>(favorMapper.selectByExample(example));
    }

    /**
     * Favor分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Favor> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Favor>(favorMapper.selectAll());
    }

    /**
     * Favor条件查询
     * @param favor
     * @return
     */
    @Override
    public List<Favor> findList(Favor favor){
        //构建查询条件
        Example example = createExample(favor);
        //根据构建的条件查询数据
        return favorMapper.selectByExample(example);
    }


    /**
     * Favor构建查询对象
     * @param favor
     * @return
     */
    public Example createExample(Favor favor){
        Example example=new Example(Favor.class);
        Example.Criteria criteria = example.createCriteria();
        if(favor!=null){
            // 收藏主键id
            if(!StringUtils.isEmpty(favor.getId())){
                    criteria.andEqualTo("id",favor.getId());
            }
            // 博文id
            if(!StringUtils.isEmpty(favor.getObjectId())){
                    criteria.andEqualTo("objectId",favor.getObjectId());
            }
            // 用户id
            if(!StringUtils.isEmpty(favor.getUserId())){
                    criteria.andEqualTo("userId",favor.getUserId());
            }
            // 收藏时间
            if(!StringUtils.isEmpty(favor.getCreateTime())){
                    criteria.andEqualTo("createTime",favor.getCreateTime());
            }
            // 博文类型(1博客，2模型，3指南)
            if(!StringUtils.isEmpty(favor.getObjectType())){
                    criteria.andEqualTo("objectType",favor.getObjectType());
            }
            // 状态(1正常，2被删除)
            if(!StringUtils.isEmpty(favor.getStatus())){
                    criteria.andEqualTo("status",favor.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        favorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Favor
     * @param favor
     */
    @Override
    public void update(Favor favor){
        favorMapper.updateByPrimaryKey(favor);
    }

    /**
     * 增加Favor
     * @param favor
     */
    @Override
    public void add(Favor favor){
        favorMapper.insert(favor);
    }

    /**
     * 根据ID查询Favor
     * @param id
     * @return
     */
    @Override
    public Favor findById(Long id){
        return  favorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Favor全部数据
     * @return
     */
    @Override
    public List<Favor> findAll() {
        return favorMapper.selectAll();
    }
}
