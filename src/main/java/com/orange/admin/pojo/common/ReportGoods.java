package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class ReportGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 11,unique = true)
    private Long id;


    @Column(nullable=false)
    @CreatedDate
    private Date createTime;//创建时间

    @ManyToOne
    @JoinColumn()
    private Customer customer;//所属学生

    @ManyToOne
    @JoinColumn(name="goods_id")
    private Goods goods;//举报的物品

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=1000,errorRequiredMsg="举报原因不能为空!",errorMinlenthMsg="举报原因长度需大于1!",errorMaxlenthMsg="举报原因长度不能大于1000!")
    @Column(nullable=false,length=1024)
    private String content;//举报原因

    public ReportGoods() {
    }

    @Override
    public String toString() {
        return "ReportGoods{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", customer=" + customer +
                ", goods=" + goods +
                ", content='" + content + '\'' +
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
