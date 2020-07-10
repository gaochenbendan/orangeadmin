package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity

@EntityListeners(AuditingEntityListener.class)
public class SiteSetting  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 11,unique = true)
    private Long id;

    @Column(name="create_time")
    @CreatedDate
    private Date createTime;

    @Column(name="update_time",nullable=false)
    @LastModifiedDate
    private Date updateTime;
    
    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=64,errorRequiredMsg="网站名称不能为空!",errorMinlenthMsg="网站名称长度需大于1!",errorMaxlenthMsg="网站设置名称长度不能大于128!")
    @Column(name="site_name",nullable=false,length=128)
    private String siteName;


    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=256,errorRequiredMsg="网站URL地址不能为空!",errorMinlenthMsg="网站URL地址长度需大于1!",errorMaxlenthMsg="网站URL地址长度不能大于256!")
    @Column(name="site_url",nullable=false,length=256)
    private String siteUrl;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=0,maxLength=256,errorRequiredMsg="网站logo不能为空!",errorMinlenthMsg="网站logo长度需大于1!",errorMaxlenthMsg="网站logo长度不能大于256!")
    @Column(name="logo_1",nullable=false,length=256)
    private String logo1;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=0,maxLength=256,errorRequiredMsg="网站logo不能为空!",errorMinlenthMsg="网站logo长度需大于1!",errorMaxlenthMsg="网站logo长度不能大于256!")
    @Column(name="logo_2",nullable=false,length=256)
    private String logo2;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=0,maxLength=256,errorRequiredMsg="网站公众号二维码不能为空!",errorMinlenthMsg="网站公众号二维码长度需大于1!",errorMaxlenthMsg="网站公众号二维码长度不能大于256!")
    @Column(name="qrcode",nullable=false,length=256)
    private String qrcode;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=256,errorRequiredMsg="网站版权信息不能为空!",errorMinlenthMsg="网站版权信息长度需大于1!",errorMaxlenthMsg="网站版权信息长度不能大于256!")
    @Column(name="all_rights",nullable=false,length=256)
    private String allRights;


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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getLogo1() {
        return logo1;
    }

    public void setLogo1(String logo1) {
        this.logo1 = logo1;
    }

    public String getLogo2() {
        return logo2;
    }

    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getAllRights() {
        return allRights;
    }

    public void setAllRights(String allRights) {
        this.allRights = allRights;
    }
}
