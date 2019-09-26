package com.mht.util.restTemplateUtils;

public class DataBean {
    private int noticeId;
    private String noticeTitle;
    private Object noticeImg;
    private long noticeCreateTime;
    private long noticeUpdateTime;
    private String noticeContent;

    public DataBean() {
    }

    public DataBean(int noticeId, String noticeTitle, Object noticeImg, long noticeCreateTime, long noticeUpdateTime, String noticeContent) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeImg = noticeImg;
        this.noticeCreateTime = noticeCreateTime;
        this.noticeUpdateTime = noticeUpdateTime;
        this.noticeContent = noticeContent;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Object getNoticeImg() {
        return noticeImg;
    }

    public void setNoticeImg(Object noticeImg) {
        this.noticeImg = noticeImg;
    }

    public long getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(long noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public long getNoticeUpdateTime() {
        return noticeUpdateTime;
    }

    public void setNoticeUpdateTime(long noticeUpdateTime) {
        this.noticeUpdateTime = noticeUpdateTime;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeImg=" + noticeImg +
                ", noticeCreateTime=" + noticeCreateTime +
                ", noticeUpdateTime=" + noticeUpdateTime +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}
