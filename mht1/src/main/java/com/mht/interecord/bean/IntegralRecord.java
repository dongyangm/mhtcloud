package com.mht.interecord.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "integral_record")
public class IntegralRecord {

    @Id
    String id;

    String userId;

    String userName;

    int haveIntegral;

    Date haveTime;

    String businessId;

    String businessName;

    public IntegralRecord() {
    }

    public IntegralRecord(String id, String userId, String userName, int haveIntegral, Date haveTime, String businessId, String businessName) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.haveIntegral = haveIntegral;
        this.haveTime = haveTime;
        this.businessId = businessId;
        this.businessName = businessName;
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

    public int getHaveIntegral() {
        return haveIntegral;
    }

    public void setHaveIntegral(int haveIntegral) {
        this.haveIntegral = haveIntegral;
    }

    public Date getHaveTime() {
        return haveTime;
    }

    public void setHaveTime(Date haveTime) {
        this.haveTime = haveTime;
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

    @Override
    public String toString() {
        return "IntegralRecord{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", haveIntegral=" + haveIntegral +
                ", haveTime=" + haveTime +
                ", businessId='" + businessId + '\'' +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
