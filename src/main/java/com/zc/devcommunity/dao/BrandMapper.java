package com.zc.devcommunity.dao;


import com.zc.devcommunity.pojo.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/*
* DAO使用通用Mapper,Dao接口需要继承tk.mybatis.mapper.common.Mapper
*
* 增加数据： Mapper.insert(T)
*          Mapper.insertSelective()
*
* 修改数据： Mapper.update(T)
*          Mapper.updateByPrimaryKey(T)
*
* 查询数据： Mapper.selectByPrimaryKey(ID)
*          Mapper.select(T)
* */
@Repository // 为了解决autowired爆红 https://blog.csdn.net/sinat_36710456/article/details/80143986
public interface BrandMapper extends Mapper<Brand> {

}
