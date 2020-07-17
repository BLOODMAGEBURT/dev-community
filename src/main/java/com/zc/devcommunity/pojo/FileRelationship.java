package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:xujianbo
 * @Description:FileRelationship构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="file_relationship")
public class FileRelationship implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键id

    @Column(name = "object_id")
	private Long objectId;//博文id

    @Column(name = "file_id")
	private Long fileId;//文件id

    @Column(name = "file_order")
	private Integer fileOrder;//文件排序



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
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
	public Long getFileId() {
		return fileId;
	}

	//set方法
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	//get方法
	public Integer getFileOrder() {
		return fileOrder;
	}

	//set方法
	public void setFileOrder(Integer fileOrder) {
		this.fileOrder = fileOrder;
	}


}
