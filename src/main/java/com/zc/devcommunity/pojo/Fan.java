package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:Fan构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="fan")
public class Fan implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键id

    @Column(name = "followed_id")
	private Long followedId;//我关注的

    @Column(name = "follower_id")
	private Long followerId;//关注我的

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
	public Long getFollowedId() {
		return followedId;
	}

	//set方法
	public void setFollowedId(Long followedId) {
		this.followedId = followedId;
	}
	//get方法
	public Long getFollowerId() {
		return followerId;
	}

	//set方法
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
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
