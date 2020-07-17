package com.zc.devcommunity.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:xujianbo
 * @Description:File构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="file")
public class File implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//文件id

    @Column(name = "url")
	private String url;//文件url地址

    @Column(name = "name")
	private String name;//文件名称

    @Column(name = "size")
	private Integer size;//文件大小

    @Column(name = "ext")
	private String ext;//文件扩展类型

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
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
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
	public Integer getSize() {
		return size;
	}

	//set方法
	public void setSize(Integer size) {
		this.size = size;
	}
	//get方法
	public String getExt() {
		return ext;
	}

	//set方法
	public void setExt(String ext) {
		this.ext = ext;
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
