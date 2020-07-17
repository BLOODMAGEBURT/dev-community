package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.DevDocMapper;
import com.zc.devcommunity.pojo.DevDoc;
import com.zc.devcommunity.service.DevDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:DevDoc业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DevDocServiceImpl implements DevDocService {

    @Autowired
    private DevDocMapper devDocMapper;


    /**
     * DevDoc条件+分页查询
     * @param devDoc 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<DevDoc> findPage(DevDoc devDoc, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(devDoc);
        //执行搜索
        return new PageInfo<DevDoc>(devDocMapper.selectByExample(example));
    }

    /**
     * DevDoc分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<DevDoc> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<DevDoc>(devDocMapper.selectAll());
    }

    /**
     * DevDoc条件查询
     * @param devDoc
     * @return
     */
    @Override
    public List<DevDoc> findList(DevDoc devDoc){
        //构建查询条件
        Example example = createExample(devDoc);
        //根据构建的条件查询数据
        return devDocMapper.selectByExample(example);
    }


    /**
     * DevDoc构建查询对象
     * @param devDoc
     * @return
     */
    public Example createExample(DevDoc devDoc){
        Example example=new Example(DevDoc.class);
        Example.Criteria criteria = example.createCriteria();
        if(devDoc!=null){
            // 指南id
            if(!StringUtils.isEmpty(devDoc.getId())){
                    criteria.andEqualTo("id",devDoc.getId());
            }
            // 管理员id
            if(!StringUtils.isEmpty(devDoc.getAdmin())){
                    criteria.andEqualTo("admin",devDoc.getAdmin());
            }
            // 标题
            if(!StringUtils.isEmpty(devDoc.getTitle())){
                    criteria.andLike("title","%"+devDoc.getTitle()+"%");
            }
            // 内容
            if(!StringUtils.isEmpty(devDoc.getContent())){
                    criteria.andEqualTo("content",devDoc.getContent());
            }
            // 摘要
            if(!StringUtils.isEmpty(devDoc.getSummary())){
                    criteria.andEqualTo("summary",devDoc.getSummary());
            }
            // 创建时间
            if(!StringUtils.isEmpty(devDoc.getCreateTime())){
                    criteria.andEqualTo("createTime",devDoc.getCreateTime());
            }
            // 修改时间
            if(!StringUtils.isEmpty(devDoc.getEditTime())){
                    criteria.andEqualTo("editTime",devDoc.getEditTime());
            }
            // 附件下载数
            if(!StringUtils.isEmpty(devDoc.getFileDlCount())){
                    criteria.andEqualTo("fileDlCount",devDoc.getFileDlCount());
            }
            // 评论数量
            if(!StringUtils.isEmpty(devDoc.getCommentCount())){
                    criteria.andEqualTo("commentCount",devDoc.getCommentCount());
            }
            // 状态(1正常，2被管理员删除，3被管理员隐藏)
            if(!StringUtils.isEmpty(devDoc.getStatus())){
                    criteria.andEqualTo("status",devDoc.getStatus());
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
        devDocMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改DevDoc
     * @param devDoc
     */
    @Override
    public void update(DevDoc devDoc){
        devDocMapper.updateByPrimaryKey(devDoc);
    }

    /**
     * 增加DevDoc
     * @param devDoc
     */
    @Override
    public void add(DevDoc devDoc){
        devDocMapper.insert(devDoc);
    }

    /**
     * 根据ID查询DevDoc
     * @param id
     * @return
     */
    @Override
    public DevDoc findById(Long id){
        return  devDocMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询DevDoc全部数据
     * @return
     */
    @Override
    public List<DevDoc> findAll() {
        return devDocMapper.selectAll();
    }
}
