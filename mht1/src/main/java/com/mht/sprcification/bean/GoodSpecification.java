package com.mht.sprcification.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "good_specification")
@Entity
public class GoodSpecification {

    @Id
    private String id;

    private String goodId;

    private String specification;

    private float price;

    private Date createTime;

    public GoodSpecification() {
    }

    public GoodSpecification(String id, String goodId, String specification, float price, Date createTime) {
        this.id = id;
        this.goodId = goodId;
        this.specification = specification;
        this.price = price;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GoodSpecification{" +
                "id='" + id + '\'' +
                ", goodId='" + goodId + '\'' +
                ", specification='" + specification + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }
}
