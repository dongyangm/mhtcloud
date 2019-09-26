package com.mht.goods.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "good")
public class Good {

    @Id
    private String id;

    private Long goodsCategory;

    private String goodsName;

    private String priceRange;

    private Date createTime;

    private String img;

    private String product; //产地

    private String standard;

    private float weight;

    private String pack;

    private String storage;

    private int soldNum;

    private String businessId;

    private String businessName;

    private int viewNum;

    private int level;

    public Good() {
    }

    public Good(String id, Long goodsCategory, String goodsName, String priceRange, Date createTime, String img, String product, String standard, float weight, String pack, String storage, int soldNum, String businessId, String businessName, int viewNum, int level) {
        this.id = id;
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.priceRange = priceRange;
        this.createTime = createTime;
        this.img = img;
        this.product = product;
        this.standard = standard;
        this.weight = weight;
        this.pack = pack;
        this.storage = storage;
        this.soldNum = soldNum;
        this.businessId = businessId;
        this.businessName = businessName;
        this.viewNum = viewNum;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(Long goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id='" + id + '\'' +
                ", goodsCategory=" + goodsCategory +
                ", goodsName='" + goodsName + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", createTime=" + createTime +
                ", img='" + img + '\'' +
                ", product='" + product + '\'' +
                ", standard='" + standard + '\'' +
                ", weight=" + weight +
                ", pack='" + pack + '\'' +
                ", storage='" + storage + '\'' +
                ", soldNum=" + soldNum +
                ", businessId='" + businessId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", viewNum=" + viewNum +
                ", level=" + level +
                '}';
    }
}
