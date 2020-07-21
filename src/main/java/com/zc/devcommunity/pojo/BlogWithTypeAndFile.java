package com.zc.devcommunity.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BlogWithTypeAndFile.java
 * @Description TODO
 * @createTime 2020年07月21日 16:52:00
 */
public class BlogWithTypeAndFile implements Serializable {
    // 博客
    private Blog blog;
    // 附件
    private List<File> files;
    // 分类
    private List<Term> terms;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }
}
