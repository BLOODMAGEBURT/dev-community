package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:Favor构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="favor")
public class Favor implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//收藏主键id

    @Column(name = "object_id")
	private Long objectId;//博文id

    @Column(name = "user_id")
	private Long userId;//用户id

    @Column(name = "create_time")
	private Date createTime;//收藏时间

    @Column(name = "object_type")
	private Integer objectType;//博文类型(1博客，2模型，3指南)

    @Column(name = "status")
	private Integer status;//状态(1正常，2被删除)



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
	public Long getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Integer getObjectType() {
		return objectType;
	}

	//set方法
	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
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
