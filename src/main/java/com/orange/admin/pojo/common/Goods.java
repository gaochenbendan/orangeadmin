package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Goods {

    public static final int GOODS_STATUS_UP = 1;//上架
    public static final int GOODS_STATUS_DOWN = 2;//下架
    public static final int GOODS_STATUS_SOLD = 3;//已售出

    public static final int GOODS_FLAG_ON = 1;//擦亮
    public static final int GOODS_FLAG_OFF = 0;//不擦亮

    public static final int GOODS_RECOMMEND_OFF = 0;//不推荐
    public static final int GOODS_RECOMMEND_ON = 1;//推荐

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 11,unique = true)
    private Long id;

    @Column(name="create_time")
    @CreatedDate
    private Date createTime;//创建时间

    @Column(name="update_time",nullable=false)
    @LastModifiedDate
    private Date updateTime;//更新时间

    @ManyToOne
    private Customer customer;//所属学生

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=30,errorRequiredMsg="物品名称不能为空!",errorMinlenthMsg="物品名称长度需大于1!",errorMaxlenthMsg="物品名称长度不能大于30!")
    @Column(name="name",nullable=false,length=32)
    private String name;//物品名称

    @ManyToOne
    @JoinColumn(name="goods_category_id")
    private GoodsCategory goodsCategory;//物品分类

    @ValidateAnnotion(required=true,errorRequiredMsg="请填写购买价格",requiredMinValue=true,errorMinValueMsg="购买价格不能小于0")
    @Column(name="buy_price",nullable=false,length=8)
    private Float buyPrice;//购买价格

    @ValidateAnnotion(required=true,errorRequiredMsg="请填写出售价格",requiredMinValue=true,errorMinValueMsg="出售价格不能小于0")
    @Column(name="sell_price",nullable=false,length=8)
    private Float sellPrice;//出售价格

    @ValidateAnnotion(required=true,errorRequiredMsg="请上传图片")
    @Column(name="photo",nullable=false,length=128)
    private String photo;//物品图片

    @Column(name="status",nullable=false,length=1)
    private int status = GOODS_STATUS_UP;//物品状态，默认上架

    @Column(name="flag",nullable=false,length=1)
    private int flag = GOODS_FLAG_OFF;//是否擦亮

    @Column(name="recommend",nullable=false,length=1)
    private int recommend = GOODS_RECOMMEND_OFF;//是否推荐

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=1000,errorRequiredMsg="物品详情描述不能为空!",errorMinlenthMsg="物品详情描述长度需大于1!",errorMaxlenthMsg="物品详情描述长度不能大于1000!")
    @Column(name="content",nullable=false,length=1024)
    private String content;//物品详情描述

    @Column(name="view_number",nullable=false,length=8)
    private int viewNumber = 0;//物品浏览量

    public Goods() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsCategory getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", customer=" + customer +
                ", name='" + name + '\'' +
                ", goodsCategory=" + goodsCategory +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", photo='" + photo + '\'' +
                ", status=" + status +
                ", flag=" + flag +
                ", recommend=" + recommend +
                ", content='" + content + '\'' +
                ", viewNumber=" + viewNumber +
                '}';
    }
}
