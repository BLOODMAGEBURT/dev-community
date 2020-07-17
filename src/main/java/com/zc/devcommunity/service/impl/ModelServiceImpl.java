package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.ModelMapper;
import com.zc.devcommunity.pojo.Model;
import com.zc.devcommunity.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Model业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Model条件+分页查询
     * @param model 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Model> findPage(Model model, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(model);
        //执行搜索
        return new PageInfo<Model>(modelMapper.selectByExample(example));
    }

    /**
     * Model分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Model> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Model>(modelMapper.selectAll());
    }

    /**
     * Model条件查询
     * @param model
     * @return
     */
    @Override
    public List<Model> findList(Model model){
        //构建查询条件
        Example example = createExample(model);
        //根据构建的条件查询数据
        return modelMapper.selectByExample(example);
    }


    /**
     * Model构建查询对象
     * @param model
     * @return
     */
    public Example createExample(Model model){
        Example example=new Example(Model.class);
        Example.Criteria criteria = example.createCriteria();
        if(model!=null){
            // 模型id
            if(!StringUtils.isEmpty(model.getId())){
                    criteria.andEqualTo("id",model.getId());
            }
            // 作者id
            if(!StringUtils.isEmpty(model.getAutherId())){
                    criteria.andEqualTo("autherId",model.getAutherId());
            }
            // 标题
            if(!StringUtils.isEmpty(model.getTitle())){
                    criteria.andLike("title","%"+model.getTitle()+"%");
            }
            // 内容
            if(!StringUtils.isEmpty(model.getContent())){
                    criteria.andEqualTo("content",model.getContent());
            }
            // 摘要
            if(!StringUtils.isEmpty(model.getSummary())){
                    criteria.andEqualTo("summary",model.getSummary());
            }
            // 创建时间
            if(!StringUtils.isEmpty(model.getCreateTime())){
                    criteria.andEqualTo("createTime",model.getCreateTime());
            }
            // 修改时间
            if(!StringUtils.isEmpty(model.getEditTime())){
                    criteria.andEqualTo("editTime",model.getEditTime());
            }
            // 浏览量
            if(!StringUtils.isEmpty(model.getViewCount())){
                    criteria.andEqualTo("viewCount",model.getViewCount());
            }
            // 评论数量
            if(!StringUtils.isEmpty(model.getCommentCount())){
                    criteria.andEqualTo("commentCount",model.getCommentCount());
            }
            // 模型下载数量
            if(!StringUtils.isEmpty(model.getFileDlCount())){
                    criteria.andEqualTo("fileDlCount",model.getFileDlCount());
            }
            // 状态(1正常，2被博主删除，3被管理删除，4被博主隐藏，5被管理员隐藏)
            if(!StringUtils.isEmpty(model.getStatus())){
                    criteria.andEqualTo("status",model.getStatus());
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
        modelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Model
     * @param model
     */
    @Override
    public void update(Model model){
        modelMapper.updateByPrimaryKey(model);
    }

    /**
     * 增加Model
     * @param model
     */
    @Override
    public void add(Model model){
        modelMapper.insert(model);
    }

    /**
     * 根据ID查询Model
     * @param id
     * @return
     */
    @Override
    public Model findById(Long id){
        return  modelMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Model全部数据
     * @return
     */
    @Override
    public List<Model> findAll() {
        return modelMapper.selectAll();
    }
}
