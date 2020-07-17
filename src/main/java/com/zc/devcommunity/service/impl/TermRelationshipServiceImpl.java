package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.TermRelationshipMapper;
import com.zc.devcommunity.pojo.TermRelationship;
import com.zc.devcommunity.service.TermRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:TermRelationship业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TermRelationshipServiceImpl implements TermRelationshipService {

    @Autowired
    private TermRelationshipMapper termRelationshipMapper;


    /**
     * TermRelationship条件+分页查询
     * @param termRelationship 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<TermRelationship> findPage(TermRelationship termRelationship, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(termRelationship);
        //执行搜索
        return new PageInfo<TermRelationship>(termRelationshipMapper.selectByExample(example));
    }

    /**
     * TermRelationship分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<TermRelationship> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TermRelationship>(termRelationshipMapper.selectAll());
    }

    /**
     * TermRelationship条件查询
     * @param termRelationship
     * @return
     */
    @Override
    public List<TermRelationship> findList(TermRelationship termRelationship){
        //构建查询条件
        Example example = createExample(termRelationship);
        //根据构建的条件查询数据
        return termRelationshipMapper.selectByExample(example);
    }


    /**
     * TermRelationship构建查询对象
     * @param termRelationship
     * @return
     */
    public Example createExample(TermRelationship termRelationship){
        Example example=new Example(TermRelationship.class);
        Example.Criteria criteria = example.createCriteria();
        if(termRelationship!=null){
            // 主键id
            if(!StringUtils.isEmpty(termRelationship.getId())){
                    criteria.andEqualTo("id",termRelationship.getId());
            }
            // 博文的id
            if(!StringUtils.isEmpty(termRelationship.getObjectId())){
                    criteria.andEqualTo("objectId",termRelationship.getObjectId());
            }
            // 分类id
            if(!StringUtils.isEmpty(termRelationship.getTermId())){
                    criteria.andEqualTo("termId",termRelationship.getTermId());
            }
            // 分类排序
            if(!StringUtils.isEmpty(termRelationship.getTermOrder())){
                    criteria.andEqualTo("termOrder",termRelationship.getTermOrder());
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
        termRelationshipMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TermRelationship
     * @param termRelationship
     */
    @Override
    public void update(TermRelationship termRelationship){
        termRelationshipMapper.updateByPrimaryKey(termRelationship);
    }

    /**
     * 增加TermRelationship
     * @param termRelationship
     */
    @Override
    public void add(TermRelationship termRelationship){
        termRelationshipMapper.insert(termRelationship);
    }

    /**
     * 根据ID查询TermRelationship
     * @param id
     * @return
     */
    @Override
    public TermRelationship findById(Long id){
        return  termRelationshipMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询TermRelationship全部数据
     * @return
     */
    @Override
    public List<TermRelationship> findAll() {
        return termRelationshipMapper.selectAll();
    }
}
