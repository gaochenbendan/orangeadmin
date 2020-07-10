package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class FriendLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 11,unique = true)
    private Long id;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=64,errorRequiredMsg="友情链接名称不能为空!",errorMinlenthMsg="友情链接名称长度需大于1!",errorMaxlenthMsg="友情链接名称长度不能大于64!")
    @Column(name="name",nullable=false,length=64)
    private String name;//友情链接名称


    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=256,errorRequiredMsg="友情链接URL地址不能为空!",errorMinlenthMsg="友情链接URL地址长度需大于1!",errorMaxlenthMsg="友情链接URL地址长度不能大于256!")
    @Column(name="url",nullable=false,length=256)
    private String url;//友情链接地址

    @Column(name="sort",nullable=false,length=4)
    private Integer sort = 0;//显示顺序，默认升序排列,默认是0


    @Column(nullable=false)
    @CreatedDate
    private Date createTime;//创建时间


    public FriendLink() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
