package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.FileRelationshipMapper;
import com.zc.devcommunity.pojo.FileRelationship;
import com.zc.devcommunity.service.FileRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:FileRelationship业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FileRelationshipServiceImpl implements FileRelationshipService {

    @Autowired
    private FileRelationshipMapper fileRelationshipMapper;


    /**
     * FileRelationship条件+分页查询
     * @param fileRelationship 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<FileRelationship> findPage(FileRelationship fileRelationship, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(fileRelationship);
        //执行搜索
        return new PageInfo<FileRelationship>(fileRelationshipMapper.selectByExample(example));
    }

    /**
     * FileRelationship分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<FileRelationship> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<FileRelationship>(fileRelationshipMapper.selectAll());
    }

    /**
     * FileRelationship条件查询
     * @param fileRelationship
     * @return
     */
    @Override
    public List<FileRelationship> findList(FileRelationship fileRelationship){
        //构建查询条件
        Example example = createExample(fileRelationship);
        //根据构建的条件查询数据
        return fileRelationshipMapper.selectByExample(example);
    }


    /**
     * FileRelationship构建查询对象
     * @param fileRelationship
     * @return
     */
    public Example createExample(FileRelationship fileRelationship){
        Example example=new Example(FileRelationship.class);
        Example.Criteria criteria = example.createCriteria();
        if(fileRelationship!=null){
            // 主键id
            if(!StringUtils.isEmpty(fileRelationship.getId())){
                    criteria.andEqualTo("id",fileRelationship.getId());
            }
            // 博文id
            if(!StringUtils.isEmpty(fileRelationship.getObjectId())){
                    criteria.andEqualTo("objectId",fileRelationship.getObjectId());
            }
            // 文件id
            if(!StringUtils.isEmpty(fileRelationship.getFileId())){
                    criteria.andEqualTo("fileId",fileRelationship.getFileId());
            }
            // 文件排序
            if(!StringUtils.isEmpty(fileRelationship.getFileOrder())){
                    criteria.andEqualTo("fileOrder",fileRelationship.getFileOrder());
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
        fileRelationshipMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改FileRelationship
     * @param fileRelationship
     */
    @Override
    public void update(FileRelationship fileRelationship){
        fileRelationshipMapper.updateByPrimaryKey(fileRelationship);
    }

    /**
     * 增加FileRelationship
     * @param fileRelationship
     */
    @Override
    public void add(FileRelationship fileRelationship){
        fileRelationshipMapper.insert(fileRelationship);
    }

    /**
     * 根据ID查询FileRelationship
     * @param id
     * @return
     */
    @Override
    public FileRelationship findById(Long id){
        return  fileRelationshipMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询FileRelationship全部数据
     * @return
     */
    @Override
    public List<FileRelationship> findAll() {
        return fileRelationshipMapper.selectAll();
    }
}
