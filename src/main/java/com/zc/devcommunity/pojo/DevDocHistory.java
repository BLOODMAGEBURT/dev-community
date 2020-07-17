package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:DevDocHistory构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="dev_doc_history")
public class DevDocHistory implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//指南id

    @Column(name = "admin")
	private Long admin;//修改的管理员id

    @Column(name = "doc_id")
	private Long docId;//指南id

    @Column(name = "create_time")
	private Date createTime;//创建时间



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
	public Long getDocId() {
		return docId;
	}

	//set方法
	public void setDocId(Long docId) {
		this.docId = docId;
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
