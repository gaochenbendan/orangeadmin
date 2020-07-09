package com.orange.admin.pojo.common;

import com.orange.admin.annotion.ValidateAnnotion;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {


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
    @JoinColumn()
    private Goods goods;//评论的物品

    @ValidateAnnotion(required=true,requiredLength=true,minLength=1,maxLength=1000,errorRequiredMsg="评论内容不能为空!",errorMaxlenthMsg="评论内容长度需大于1!",errorMaxValueMsg="评论内容长度不能大于1000!")
    @Column(nullable=false,length=1024)
    private String content;//评论内容


    @Column(length=64)
    private String replyTo;//回复者


    public Comment() {
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

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }
}
