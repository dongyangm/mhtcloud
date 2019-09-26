package com.mht.integral.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "integral")
public class Integral {

    @Id
    String id;

    String userId;

    String userName;

    String businessId;

    String businessName;

    int availIntegral;

    int usedIntegral;

    int totalIntegral;

    Date createTime;

    Date updateTime;

    public Integral() {
    }

    public Integral(String id, String userId, String userName, String businessId, String businessName, int availIntegral, int usedIntegral, int totalIntegral, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.businessId = businessId;
        this.businessName = businessName;
        this.availIntegral = availIntegral;
        this.usedIntegral = usedIntegral;
        this.totalIntegral = totalIntegral;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getAvailIntegral() {
        return availIntegral;
    }

    public void setAvailIntegral(int availIntegral) {
        this.availIntegral = availIntegral;
    }

    public int getUsedIntegral() {
        return usedIntegral;
    }

    public void setUsedIntegral(int usedIntegral) {
        this.usedIntegral = usedIntegral;
    }

    public int getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalntegral(int totalIntegral) {
        this.totalIntegral = totalIntegral;
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
        return "Integral{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", businessId='" + businessId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", availIntegral=" + availIntegral +
                ", usedIntegral=" + usedIntegral +
                ", totalintegral=" + totalIntegral +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
