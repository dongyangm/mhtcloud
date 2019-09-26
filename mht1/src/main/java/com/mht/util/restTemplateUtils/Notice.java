package com.mht.util.restTemplateUtils;

import java.util.List;

public class Notice {

    private int status;
    private Object msg;
    private List<DataBean> data;

    public Notice() {
    }

    public Notice(int status, Object msg, List<DataBean> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "status=" + status +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }
}
