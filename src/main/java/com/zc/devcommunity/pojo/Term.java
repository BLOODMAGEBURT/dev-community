package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:Term构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="term")
public class Term implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//分类id

    @Column(name = "name")
	private String name;//分类名称

    @Column(name = "create_time")
	private Date createTime;//创建时间

    @Column(name = "edit_time")
	private Date editTime;//修改时间

    @Column(name = "type")
	private Integer type;//分类类型(1博客，2模型，3专家)



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	public Integer getType() {
		return type;
	}

	//set方法
	public void setType(Integer type) {
		this.type = type;
	}


}
