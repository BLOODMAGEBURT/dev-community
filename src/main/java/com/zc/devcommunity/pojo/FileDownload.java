package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:FileDownload构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="file_download")
public class FileDownload implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键id

    @Column(name = "user_id")
	private Long userId;//用户id

    @Column(name = "file_id")
	private Long fileId;//文件表id

    @Column(name = "object_id")
	private Long objectId;//博文id

    @Column(name = "object_type")
	private Integer objectType;//博文类型(1博客，2模型，3指南)

    @Column(name = "create_time")
	private Date createTime;//下载时间



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	//get方法
	public Long getFileId() {
		return fileId;
	}

	//set方法
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	//get方法
	public Long getObjectId() {
		return objectId;
	}

	//set方法
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	//get方法
	public Integer getObjectType() {
		return objectType;
	}

	//set方法
	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
