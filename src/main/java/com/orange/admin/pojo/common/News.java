package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 新闻实体类
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class News {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,length = 11,unique = true)
	private Long id;
	
	@ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=64,errorRequiredMsg="新闻标题不能为空!",errorMinlenthMsg="新闻标题长度需大于1!",errorMaxlenthMsg="新闻标题长度不能大于64!")
	@Column(nullable=false,length=64)
	private String title;//新闻标题
	
	
	@ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=10000,errorRequiredMsg="新闻内容不能为空!",errorMinlenthMsg="新闻内容长度需大于1!",errorMaxlenthMsg="新闻内容长度不能大于10000!")
	@Column(nullable=false,length=10024)
	private String content;//新闻内容
	
	@Column(nullable=false,length=8)
	private Integer viewNumber = 0;

	@Column(nullable=false,length=4)
	private Integer sort = 0;//分类顺序，默认升序排列,默认是0

	@Column(nullable=false)
	@CreatedDate
	private Date createTime;//创建时间

	@Column(nullable=false)
	@LastModifiedDate
	private Date updateTime;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public News() {
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", viewNumber=" + viewNumber +
				", sort=" + sort +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
