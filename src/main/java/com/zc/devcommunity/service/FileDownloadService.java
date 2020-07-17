package com.zc.devcommunity.service;

import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.pojo.FileDownload;

import java.util.List;

/****
 * @Author:xujianbo
 * @Description:FileDownload业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FileDownloadService {

    /***
     * FileDownload多条件分页查询
     * @param fileDownload
     * @param page
     * @param size
     * @return
     */
    PageInfo<FileDownload> findPage(FileDownload fileDownload, int page, int size);

    /***
     * FileDownload分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<FileDownload> findPage(int page, int size);

    /***
     * FileDownload多条件搜索方法
     * @param fileDownload
     * @return
     */
    List<FileDownload> findList(FileDownload fileDownload);

    /***
     * 删除FileDownload
     * @param id
     */
    void delete(Long id);

    /***
     * 修改FileDownload数据
     * @param fileDownload
     */
    void update(FileDownload fileDownload);

    /***
     * 新增FileDownload
     * @param fileDownload
     */
    void add(FileDownload fileDownload);

    /**
     * 根据ID查询FileDownload
     * @param id
     * @return
     */
     FileDownload findById(Long id);

    /***
     * 查询所有FileDownload
     * @return
     */
    List<FileDownload> findAll();
}
