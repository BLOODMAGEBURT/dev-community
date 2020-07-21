package com.zc.devcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.BlogMapper;
import com.zc.devcommunity.dao.FileRelationshipMapper;
import com.zc.devcommunity.dao.TermRelationshipMapper;
import com.zc.devcommunity.entity.IdWorker;
import com.zc.devcommunity.pojo.*;
import com.zc.devcommunity.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/****
 * @Author:xujianbo
 * @Description:Blog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private FileRelationshipMapper fileRelationshipMapper;

    @Autowired
    private TermRelationshipMapper termRelationshipMapper;


    @Override
    public void saveBlogWithTypeAndFile(BlogWithTypeAndFile blogWithTypeAndFile) {
        //调用BlogService实现添加Blog
        Blog blog = blogWithTypeAndFile.getBlog();
        blog.setId(idWorker.nextId());
        blog.setCreateTime(new Date());
        blog.setEditTime(new Date());
        blog.setStatus(1);
        blogMapper.insertSelective(blog);

        // file关联
        List<File> files = blogWithTypeAndFile.getFiles();
        for (File file : files) {
            FileRelationship fileRelationship = new FileRelationship();
            fileRelationship.setId(idWorker.nextId());
            fileRelationship.setFileId(file.getId());
            fileRelationship.setObjectId(blog.getId());
            fileRelationshipMapper.insertSelective(fileRelationship);
        }
        // term 关联
        List<Term> terms = blogWithTypeAndFile.getTerms();
        for (Term term : terms) {
            TermRelationship termRelationship = new TermRelationship();
            termRelationship.setId(idWorker.nextId());
            termRelationship.setTermId(term.getId());
            termRelationship.setObjectId(blog.getId());
            termRelationshipMapper.insertSelective(termRelationship);
        }
    }

    /**
     * Blog条件+分页查询
     *
     * @param blog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Blog> findPage(Blog blog, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(blog);
        //执行搜索
        List<Blog> blogs = blogMapper.selectByExample(example);

        // 调整具体字段


        return new PageInfo<Blog>(blogMapper.selectByExample(example));
    }

    /**
     * Blog分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Blog> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<Blog>(blogMapper.selectAll());
    }

    /**
     * Blog条件查询
     *
     * @param blog
     * @return
     */
    @Override
    public List<Blog> findList(Blog blog) {
        //构建查询条件
        Example example = createExample(blog);
        //根据构建的条件查询数据
        return blogMapper.selectByExample(example);
    }


    /**
     * Blog构建查询对象
     *
     * @param blog
     * @return
     */
    public Example createExample(Blog blog) {
        Example example = new Example(Blog.class);
        Example.Criteria criteria = example.createCriteria();
        if (blog != null) {
            // 博客id
            if (!StringUtils.isEmpty(blog.getId())) {
                criteria.andEqualTo("id", blog.getId());
            }
            // 作者id
            if (!StringUtils.isEmpty(blog.getAutherId())) {
                criteria.andEqualTo("autherId", blog.getAutherId());
            }
            // 标题
            if (!StringUtils.isEmpty(blog.getTitle())) {
                criteria.andLike("title", "%" + blog.getTitle() + "%");
            }
            // 内容
            if (!StringUtils.isEmpty(blog.getContent())) {
                criteria.andEqualTo("content", blog.getContent());
            }
            // 摘要
            if (!StringUtils.isEmpty(blog.getSummary())) {
                criteria.andEqualTo("summary", blog.getSummary());
            }
            // 创建时间
            if (!StringUtils.isEmpty(blog.getCreateTime())) {
                criteria.andEqualTo("createTime", blog.getCreateTime());
            }
            // 修改时间
            if (!StringUtils.isEmpty(blog.getEditTime())) {
                criteria.andEqualTo("editTime", blog.getEditTime());
            }
            // 浏览数量
            if (!StringUtils.isEmpty(blog.getViewCount())) {
                criteria.andEqualTo("viewCount", blog.getViewCount());
            }
            // 评论数量
            if (!StringUtils.isEmpty(blog.getCommentCount())) {
                criteria.andEqualTo("commentCount", blog.getCommentCount());
            }
            // 附件下载数量
            if (!StringUtils.isEmpty(blog.getFileDlCount())) {
                criteria.andEqualTo("fileDlCount", blog.getFileDlCount());
            }
            // 状态(1正常，2被博主删除，3被管理删除，4被博主隐藏，5被管理员隐藏)
            if (!StringUtils.isEmpty(blog.getStatus())) {
                criteria.andEqualTo("status", blog.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Blog
     *
     * @param blog
     */
    @Override
    public void update(Blog blog) {
        blogMapper.updateByPrimaryKey(blog);
    }

    /**
     * 增加Blog
     *
     * @param blog
     */
    @Override
    public void add(Blog blog) {
        blogMapper.insert(blog);
    }

    /**
     * 根据ID查询Blog
     *
     * @param id
     * @return
     */
    @Override
    public Blog findById(Long id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Blog全部数据
     *
     * @return
     */
    @Override
    public List<Blog> findAll() {
        return blogMapper.selectAll();
    }
}
