package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.FileDownloadMapper;
import com.zc.devcommunity.pojo.FileDownload;
import com.zc.devcommunity.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:FileDownload业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    @Autowired
    private FileDownloadMapper fileDownloadMapper;


    /**
     * FileDownload条件+分页查询
     * @param fileDownload 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<FileDownload> findPage(FileDownload fileDownload, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(fileDownload);
        //执行搜索
        return new PageInfo<FileDownload>(fileDownloadMapper.selectByExample(example));
    }

    /**
     * FileDownload分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<FileDownload> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<FileDownload>(fileDownloadMapper.selectAll());
    }

    /**
     * FileDownload条件查询
     * @param fileDownload
     * @return
     */
    @Override
    public List<FileDownload> findList(FileDownload fileDownload){
        //构建查询条件
        Example example = createExample(fileDownload);
        //根据构建的条件查询数据
        return fileDownloadMapper.selectByExample(example);
    }


    /**
     * FileDownload构建查询对象
     * @param fileDownload
     * @return
     */
    public Example createExample(FileDownload fileDownload){
        Example example=new Example(FileDownload.class);
        Example.Criteria criteria = example.createCriteria();
        if(fileDownload!=null){
            // 主键id
            if(!StringUtils.isEmpty(fileDownload.getId())){
                    criteria.andEqualTo("id",fileDownload.getId());
            }
            // 用户id
            if(!StringUtils.isEmpty(fileDownload.getUserId())){
                    criteria.andEqualTo("userId",fileDownload.getUserId());
            }
            // 文件表id
            if(!StringUtils.isEmpty(fileDownload.getFileId())){
                    criteria.andEqualTo("fileId",fileDownload.getFileId());
            }
            // 博文id
            if(!StringUtils.isEmpty(fileDownload.getObjectId())){
                    criteria.andEqualTo("objectId",fileDownload.getObjectId());
            }
            // 博文类型(1博客，2模型，3指南)
            if(!StringUtils.isEmpty(fileDownload.getObjectType())){
                    criteria.andEqualTo("objectType",fileDownload.getObjectType());
            }
            // 下载时间
            if(!StringUtils.isEmpty(fileDownload.getCreateTime())){
                    criteria.andEqualTo("createTime",fileDownload.getCreateTime());
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
        fileDownloadMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改FileDownload
     * @param fileDownload
     */
    @Override
    public void update(FileDownload fileDownload){
        fileDownloadMapper.updateByPrimaryKey(fileDownload);
    }

    /**
     * 增加FileDownload
     * @param fileDownload
     */
    @Override
    public void add(FileDownload fileDownload){
        fileDownloadMapper.insert(fileDownload);
    }

    /**
     * 根据ID查询FileDownload
     * @param id
     * @return
     */
    @Override
    public FileDownload findById(Long id){
        return  fileDownloadMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询FileDownload全部数据
     * @return
     */
    @Override
    public List<FileDownload> findAll() {
        return fileDownloadMapper.selectAll();
    }
}
