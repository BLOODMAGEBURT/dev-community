package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.AdminMapper;
import com.zc.devcommunity.pojo.Admin;
import com.zc.devcommunity.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Admin业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * Admin条件+分页查询
     * @param admin 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Admin> findPage(Admin admin, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(admin);
        //执行搜索
        return new PageInfo<Admin>(adminMapper.selectByExample(example));
    }

    /**
     * Admin分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Admin> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Admin>(adminMapper.selectAll());
    }

    /**
     * Admin条件查询
     * @param admin
     * @return
     */
    @Override
    public List<Admin> findList(Admin admin){
        //构建查询条件
        Example example = createExample(admin);
        //根据构建的条件查询数据
        return adminMapper.selectByExample(example);
    }


    /**
     * Admin构建查询对象
     * @param admin
     * @return
     */
    public Example createExample(Admin admin){
        Example example=new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        if(admin!=null){
            // 主键id
            if(!StringUtils.isEmpty(admin.getId())){
                    criteria.andEqualTo("id",admin.getId());
            }
            // 登录名
            if(!StringUtils.isEmpty(admin.getUsername())){
                    criteria.andLike("username","%"+admin.getUsername()+"%");
            }
            // 登陆密码
            if(!StringUtils.isEmpty(admin.getPassword())){
                    criteria.andEqualTo("password",admin.getPassword());
            }
            // 姓名
            if(!StringUtils.isEmpty(admin.getName())){
                    criteria.andLike("name","%"+admin.getName()+"%");
            }
            // 手机号
            if(!StringUtils.isEmpty(admin.getTelphone())){
                    criteria.andEqualTo("telphone",admin.getTelphone());
            }
            // 邮箱
            if(!StringUtils.isEmpty(admin.getEmail())){
                    criteria.andEqualTo("email",admin.getEmail());
            }
            // 头像
            if(!StringUtils.isEmpty(admin.getUserPic())){
                    criteria.andEqualTo("userPic",admin.getUserPic());
            }
            // 创建时间
            if(!StringUtils.isEmpty(admin.getCreateTime())){
                    criteria.andEqualTo("createTime",admin.getCreateTime());
            }
            // 修改时间
            if(!StringUtils.isEmpty(admin.getEditTime())){
                    criteria.andEqualTo("editTime",admin.getEditTime());
            }
            // 状态(1正常，2停用，3删除)
            if(!StringUtils.isEmpty(admin.getStatus())){
                    criteria.andEqualTo("status",admin.getStatus());
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
        adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Admin
     * @param admin
     */
    @Override
    public void update(Admin admin){
        adminMapper.updateByPrimaryKey(admin);
    }

    /**
     * 增加Admin
     * @param admin
     */
    @Override
    public void add(Admin admin){
        adminMapper.insert(admin);
    }

    /**
     * 根据ID查询Admin
     * @param id
     * @return
     */
    @Override
    public Admin findById(Long id){
        return  adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Admin全部数据
     * @return
     */
    @Override
    public List<Admin> findAll() {
        return adminMapper.selectAll();
    }
}
