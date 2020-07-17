package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:Admin构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="admin")
public class Admin implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//主键id

    @Column(name = "username")
	private String username;//登录名

    @Column(name = "password")
	private String password;//登陆密码

    @Column(name = "name")
	private String name;//姓名

    @Column(name = "telphone")
	private String telphone;//手机号

    @Column(name = "email")
	private String email;//邮箱

    @Column(name = "user_pic")
	private String userPic;//头像

    @Column(name = "create_time")
	private Date createTime;//创建时间

    @Column(name = "edit_time")
	private Date editTime;//修改时间

    @Column(name = "status")
	private Integer status;//状态(1正常，2停用，3删除)



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
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
	public String getTelphone() {
		return telphone;
	}

	//set方法
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	//get方法
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
	}
	//get方法
	public String getUserPic() {
		return userPic;
	}

	//set方法
	public void setUserPic(String userPic) {
		this.userPic = userPic;
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
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}


}
