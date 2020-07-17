package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:DevDoc构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="dev_doc")
public class DevDoc implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//指南id

    @Column(name = "admin")
	private Long admin;//管理员id

    @Column(name = "title")
	private String title;//标题

    @Column(name = "content")
	private String content;//内容

    @Column(name = "summary")
	private String summary;//摘要

    @Column(name = "create_time")
	private Date createTime;//创建时间

    @Column(name = "edit_time")
	private Date editTime;//修改时间

    @Column(name = "file_dl_count")
	private Integer fileDlCount;//附件下载数

    @Column(name = "comment_count")
	private Integer commentCount;//评论数量

    @Column(name = "status")
	private Integer status;//状态(1正常，2被管理员删除，3被管理员隐藏)



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getAdmin() {
		return admin;
	}

	//set方法
	public void setAdmin(Long admin) {
		this.admin = admin;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public String getContent() {
		return content;
	}

	//set方法
	public void setContent(String content) {
		this.content = content;
	}
	//get方法
	public String getSummary() {
		return summary;
	}

	//set方法
	public void setSummary(String summary) {
		this.summary = summary;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getEditTime() {
		return editTime;
	}

	//set方法
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	//get方法
	public Integer getFileDlCount() {
		return fileDlCount;
	}

	//set方法
	public void setFileDlCount(Integer fileDlCount) {
		this.fileDlCount = fileDlCount;
	}
	//get方法
	public Integer getCommentCount() {
		return commentCount;
	}

	//set方法
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	//get方法
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}


}
