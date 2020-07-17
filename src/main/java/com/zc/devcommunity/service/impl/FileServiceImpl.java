package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.FileMapper;
import com.zc.devcommunity.pojo.File;
import com.zc.devcommunity.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:File业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;


    /**
     * File条件+分页查询
     * @param file 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<File> findPage(File file, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(file);
        //执行搜索
        return new PageInfo<File>(fileMapper.selectByExample(example));
    }

    /**
     * File分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<File> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<File>(fileMapper.selectAll());
    }

    /**
     * File条件查询
     * @param file
     * @return
     */
    @Override
    public List<File> findList(File file){
        //构建查询条件
        Example example = createExample(file);
        //根据构建的条件查询数据
        return fileMapper.selectByExample(example);
    }


    /**
     * File构建查询对象
     * @param file
     * @return
     */
    public Example createExample(File file){
        Example example=new Example(File.class);
        Example.Criteria criteria = example.createCriteria();
        if(file!=null){
            // 文件id
            if(!StringUtils.isEmpty(file.getId())){
                    criteria.andEqualTo("id",file.getId());
            }
            // 文件url地址
            if(!StringUtils.isEmpty(file.getUrl())){
                    criteria.andEqualTo("url",file.getUrl());
            }
            // 文件名称
            if(!StringUtils.isEmpty(file.getName())){
                    criteria.andLike("name","%"+file.getName()+"%");
            }
            // 文件大小
            if(!StringUtils.isEmpty(file.getSize())){
                    criteria.andEqualTo("size",file.getSize());
            }
            // 文件扩展类型
            if(!StringUtils.isEmpty(file.getExt())){
                    criteria.andEqualTo("ext",file.getExt());
            }
            // 创建时间
            if(!StringUtils.isEmpty(file.getCreateTime())){
                    criteria.andEqualTo("createTime",file.getCreateTime());
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
        fileMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改File
     * @param file
     */
    @Override
    public void update(File file){
        fileMapper.updateByPrimaryKey(file);
    }

    /**
     * 增加File
     * @param file
     */
    @Override
    public void add(File file){
        fileMapper.insert(file);
    }

    /**
     * 根据ID查询File
     * @param id
     * @return
     */
    @Override
    public File findById(Long id){
        return  fileMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询File全部数据
     * @return
     */
    @Override
    public List<File> findAll() {
        return fileMapper.selectAll();
    }
}
