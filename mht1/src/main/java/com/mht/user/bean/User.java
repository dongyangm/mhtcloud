package com.mht.user.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;

    @NotNull
    private String account;

    private String password;

    private String userName;

    private int userAuth;//0:管理员，1：商家，2：买家，3、异常用户

    private int orderPermission;//下单权限:0、不可下单，1、可下单，3、禁止下单

    private String linkMan;

    private String phone;

    private String address;

    private Date createTime;

    private Date updateTime;

    public User() {
    }

    public User(String id, String account, String password, String userName, int userAuth, int orderPermission, String linkMan, String phone, String address, Date createTime, Date updateTime) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.userAuth = userAuth;
        this.orderPermission = orderPermission;
        this.linkMan = linkMan;
        this.phone = phone;
        this.address = address;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(int userAuth) {
        this.userAuth = userAuth;
    }

    public int getOrderPermission() {
        return orderPermission;
    }

    public void setOrderPermission(int orderPermission) {
        this.orderPermission = orderPermission;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userAuth=" + userAuth +
                ", orderPermission=" + orderPermission +
                ", linkMan='" + linkMan + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
