package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:xujianbo
 * @Description:TermRelationship构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="term_relationship")
public class TermRelationship implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键id

    @Column(name = "object_id")
	private Long objectId;//博文的id

    @Column(name = "term_id")
	private Long termId;//分类id

    @Column(name = "term_order")
	private Integer termOrder;//分类排序



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
	public Long getTermId() {
		return termId;
	}

	//set方法
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	//get方法
	public Integer getTermOrder() {
		return termOrder;
	}

	//set方法
	public void setTermOrder(Integer termOrder) {
		this.termOrder = termOrder;
	}


}
