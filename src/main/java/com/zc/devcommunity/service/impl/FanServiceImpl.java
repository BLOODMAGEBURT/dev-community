package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.FanMapper;
import com.zc.devcommunity.pojo.Fan;
import com.zc.devcommunity.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Fan业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FanServiceImpl implements FanService {

    @Autowired
    private FanMapper fanMapper;


    /**
     * Fan条件+分页查询
     * @param fan 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Fan> findPage(Fan fan, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(fan);
        //执行搜索
        return new PageInfo<Fan>(fanMapper.selectByExample(example));
    }

    /**
     * Fan分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Fan> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Fan>(fanMapper.selectAll());
    }

    /**
     * Fan条件查询
     * @param fan
     * @return
     */
    @Override
    public List<Fan> findList(Fan fan){
        //构建查询条件
        Example example = createExample(fan);
        //根据构建的条件查询数据
        return fanMapper.selectByExample(example);
    }


    /**
     * Fan构建查询对象
     * @param fan
     * @return
     */
    public Example createExample(Fan fan){
        Example example=new Example(Fan.class);
        Example.Criteria criteria = example.createCriteria();
        if(fan!=null){
            // 主键id
            if(!StringUtils.isEmpty(fan.getId())){
                    criteria.andEqualTo("id",fan.getId());
            }
            // 我关注的
            if(!StringUtils.isEmpty(fan.getFollowedId())){
                    criteria.andEqualTo("followedId",fan.getFollowedId());
            }
            // 关注我的
            if(!StringUtils.isEmpty(fan.getFollowerId())){
                    criteria.andEqualTo("followerId",fan.getFollowerId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(fan.getCreateTime())){
                    criteria.andEqualTo("createTime",fan.getCreateTime());
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
        fanMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Fan
     * @param fan
     */
    @Override
    public void update(Fan fan){
        fanMapper.updateByPrimaryKey(fan);
    }

    /**
     * 增加Fan
     * @param fan
     */
    @Override
    public void add(Fan fan){
        fanMapper.insert(fan);
    }

    /**
     * 根据ID查询Fan
     * @param id
     * @return
     */
    @Override
    public Fan findById(Long id){
        return  fanMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Fan全部数据
     * @return
     */
    @Override
    public List<Fan> findAll() {
        return fanMapper.selectAll();
    }
}
