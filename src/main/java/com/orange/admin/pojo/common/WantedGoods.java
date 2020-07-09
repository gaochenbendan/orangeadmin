package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 高晨
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
public class WantedGoods {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 11,unique = true)
    private Long id;


    @Column(name="create_time",nullable=false)
    @CreatedDate
    private Date createTime;//创建时间

    @Column(nullable=false)
    @LastModifiedDate
    private Date updateTime;

    @ManyToOne
    @JoinColumn()
    private Customer customer;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=30,errorRequiredMsg="物品名称不能为空!",errorMinlenthMsg="物品名称长度需大于1!",errorMaxlenthMsg="物品名称长度不能大于30!")
    @Column(nullable=false,length=32)
    private String name;

    @ValidateAnnotion(required=true,errorRequiredMsg="请填写期望价格",requiredMinValue=true,errorMinValueMsg="期望价格不能小于0")
    @Column(nullable=false,length=8)
    private Float sellPrice;

    @ValidateAnnotion(required=true,minLength=1,maxLength=128,errorRequiredMsg="期望交易地点不能为空!",errorMinlenthMsg="期望交易地点长度需大于1!",errorMaxlenthMsg="期望交易地点长度不能大于100!")
    @Column(nullable=false,length=128)
    private String tradePlace;

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=1000,errorRequiredMsg="物品详情描述不能为空!",errorMinlenthMsg="物品详情描述长度需大于1!",errorMaxlenthMsg="物品详情描述长度不能大于1000!")
    @Column(nullable=false,length=1024)
    private String content;

    @Column(nullable=false,length=8)
    private int viewNumber = 0;


    public WantedGoods() {
    }

    @Override
    public String toString() {
        return "WantedGoods{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", customer=" + customer +
                ", name='" + name + '\'' +
                ", sellPrice=" + sellPrice +
                ", tradePlace='" + tradePlace + '\'' +
                ", content='" + content + '\'' +
                ", viewNumber=" + viewNumber +
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

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getTradePlace() {
        return tradePlace;
    }

    public void setTradePlace(String tradePlace) {
        this.tradePlace = tradePlace;
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
}
