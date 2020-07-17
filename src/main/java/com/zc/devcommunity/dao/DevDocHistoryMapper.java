package com.zc.devcommunity.dao;
import com.zc.devcommunity.pojo.DevDocHistory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:xujianbo
 * @Description:DevDocHistory的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface DevDocHistoryMapper extends Mapper<DevDocHistory> {
}
