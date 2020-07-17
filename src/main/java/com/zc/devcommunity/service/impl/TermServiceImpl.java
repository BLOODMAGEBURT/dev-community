package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.TermMapper;
import com.zc.devcommunity.pojo.Term;
import com.zc.devcommunity.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Term业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TermServiceImpl implements TermService {

    @Autowired
    private TermMapper termMapper;


    /**
     * Term条件+分页查询
     * @param term 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Term> findPage(Term term, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(term);
        //执行搜索
        return new PageInfo<Term>(termMapper.selectByExample(example));
    }

    /**
     * Term分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Term> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Term>(termMapper.selectAll());
    }

    /**
     * Term条件查询
     * @param term
     * @return
     */
    @Override
    public List<Term> findList(Term term){
        //构建查询条件
        Example example = createExample(term);
        //根据构建的条件查询数据
        return termMapper.selectByExample(example);
    }


    /**
     * Term构建查询对象
     * @param term
     * @return
     */
    public Example createExample(Term term){
        Example example=new Example(Term.class);
        Example.Criteria criteria = example.createCriteria();
        if(term!=null){
            // 分类id
            if(!StringUtils.isEmpty(term.getId())){
                    criteria.andEqualTo("id",term.getId());
            }
            // 分类名称
            if(!StringUtils.isEmpty(term.getName())){
                    criteria.andLike("name","%"+term.getName()+"%");
            }
            // 创建时间
            if(!StringUtils.isEmpty(term.getCreateTime())){
                    criteria.andEqualTo("createTime",term.getCreateTime());
            }
            // 修改时间
            if(!StringUtils.isEmpty(term.getEditTime())){
                    criteria.andEqualTo("editTime",term.getEditTime());
            }
            // 分类类型(1博客，2模型，3专家)
            if(!StringUtils.isEmpty(term.getType())){
                    criteria.andEqualTo("type",term.getType());
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
        termMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Term
     * @param term
     */
    @Override
    public void update(Term term){
        termMapper.updateByPrimaryKey(term);
    }

    /**
     * 增加Term
     * @param term
     */
    @Override
    public void add(Term term){
        termMapper.insert(term);
    }

    /**
     * 根据ID查询Term
     * @param id
     * @return
     */
    @Override
    public Term findById(Long id){
        return  termMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Term全部数据
     * @return
     */
    @Override
    public List<Term> findAll() {
        return termMapper.selectAll();
    }
}
