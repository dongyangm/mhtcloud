package com.mht.util.beanUtils;

public class ResultInfo {

    private Boolean success;

    private Object data;

    private int flag;

    public ResultInfo() {
    }

    public ResultInfo(Boolean success, Object data, int flag) {
        this.success = success;
        this.data = data;
        this.flag = flag;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "success=" + success +
                ", data=" + data +
                ", flag=" + flag +
                '}';
    }
}
