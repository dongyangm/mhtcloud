package com.mht.order.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    private String orderId;

    private String goodId;

    private String goodName;

    private String merchatId;

    private String merchatName;

    private int goodNum;

    private float orderPrice;

    private String goodStander;

    private String buyerId;

    private String buyerName;

    private String receiver;

    private String phone;

    private String receiveAddress;

    private Date createTime;

    private Date dealingTime;

    private String expType;

    private String trackNum;//订单号码

    private int orderFlag;

    private int delFlag;

    private int readFlag;

    private float goodPrice;

    public Orders() {
    }

    public Orders(String orderId, String goodId, String goodName, String merchatId, String merchatName, int goodNum, float orderPrice, String goodStander, String buyerId, String buyerName, String receiver, String phone, String receiveAddress, Date createTime, Date dealingTime, String expType, String trackNum, int orderFlag, int delFlag, int readFlag, float goodPrice) {
        this.orderId = orderId;
        this.goodId = goodId;
        this.goodName = goodName;
        this.merchatId = merchatId;
        this.merchatName = merchatName;
        this.goodNum = goodNum;
        this.orderPrice = orderPrice;
        this.goodStander = goodStander;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.receiver = receiver;
        this.phone = phone;
        this.receiveAddress = receiveAddress;
        this.createTime = createTime;
        this.dealingTime = dealingTime;
        this.expType = expType;
        this.trackNum = trackNum;
        this.orderFlag = orderFlag;
        this.delFlag = delFlag;
        this.readFlag = readFlag;
        this.goodPrice = goodPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getMerchatId() {
        return merchatId;
    }

    public void setMerchatId(String merchatId) {
        this.merchatId = merchatId;
    }

    public String getMerchatName() {
        return merchatName;
    }

    public void setMerchatName(String merchatName) {
        this.merchatName = merchatName;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getGoodStander() {
        return goodStander;
    }

    public void setGoodStander(String goodStander) {
        this.goodStander = goodStander;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDealingTime() {
        return dealingTime;
    }

    public void setDealingTime(Date dealingTime) {
        this.dealingTime = dealingTime;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(String trackNum) {
        this.trackNum = trackNum;
    }

    public int getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(int orderFlag) {
        this.orderFlag = orderFlag;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public int getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(int readFlag) {
        this.readFlag = readFlag;
    }

    public float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(float goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                ", merchatId='" + merchatId + '\'' +
                ", merchatName='" + merchatName + '\'' +
                ", goodNum=" + goodNum +
                ", orderPrice=" + orderPrice +
                ", goodStander='" + goodStander + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", createTime=" + createTime +
                ", dealingTime=" + dealingTime +
                ", expType='" + expType + '\'' +
                ", trackNum='" + trackNum + '\'' +
                ", orderFlag=" + orderFlag +
                ", delFlag=" + delFlag +
                ", readFlag=" + readFlag +
                ", goodPrice=" + goodPrice +
                '}';
    }
}
