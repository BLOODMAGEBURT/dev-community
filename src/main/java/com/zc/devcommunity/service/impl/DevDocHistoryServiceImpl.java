package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.DevDocHistoryMapper;
import com.zc.devcommunity.pojo.DevDocHistory;
import com.zc.devcommunity.service.DevDocHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:DevDocHistory业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DevDocHistoryServiceImpl implements DevDocHistoryService {

    @Autowired
    private DevDocHistoryMapper devDocHistoryMapper;


    /**
     * DevDocHistory条件+分页查询
     * @param devDocHistory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<DevDocHistory> findPage(DevDocHistory devDocHistory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(devDocHistory);
        //执行搜索
        return new PageInfo<DevDocHistory>(devDocHistoryMapper.selectByExample(example));
    }

    /**
     * DevDocHistory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<DevDocHistory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<DevDocHistory>(devDocHistoryMapper.selectAll());
    }

    /**
     * DevDocHistory条件查询
     * @param devDocHistory
     * @return
     */
    @Override
    public List<DevDocHistory> findList(DevDocHistory devDocHistory){
        //构建查询条件
        Example example = createExample(devDocHistory);
        //根据构建的条件查询数据
        return devDocHistoryMapper.selectByExample(example);
    }


    /**
     * DevDocHistory构建查询对象
     * @param devDocHistory
     * @return
     */
    public Example createExample(DevDocHistory devDocHistory){
        Example example=new Example(DevDocHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(devDocHistory!=null){
            // 指南id
            if(!StringUtils.isEmpty(devDocHistory.getId())){
                    criteria.andEqualTo("id",devDocHistory.getId());
            }
            // 修改的管理员id
            if(!StringUtils.isEmpty(devDocHistory.getAdmin())){
                    criteria.andEqualTo("admin",devDocHistory.getAdmin());
            }
            // 指南id
            if(!StringUtils.isEmpty(devDocHistory.getDocId())){
                    criteria.andEqualTo("docId",devDocHistory.getDocId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(devDocHistory.getCreateTime())){
                    criteria.andEqualTo("createTime",devDocHistory.getCreateTime());
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
        devDocHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改DevDocHistory
     * @param devDocHistory
     */
    @Override
    public void update(DevDocHistory devDocHistory){
        devDocHistoryMapper.updateByPrimaryKey(devDocHistory);
    }

    /**
     * 增加DevDocHistory
     * @param devDocHistory
     */
    @Override
    public void add(DevDocHistory devDocHistory){
        devDocHistoryMapper.insert(devDocHistory);
    }

    /**
     * 根据ID查询DevDocHistory
     * @param id
     * @return
     */
    @Override
    public DevDocHistory findById(Long id){
        return  devDocHistoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询DevDocHistory全部数据
     * @return
     */
    @Override
    public List<DevDocHistory> findAll() {
        return devDocHistoryMapper.selectAll();
    }
}
