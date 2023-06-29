package com.charles.demo.Entity;

public class ResponseViewEntity<T> {
    private Integer retCode;
    private String retMsg;
    private T data;

    
    public ResponseViewEntity() {
    }

    public Integer getRetCode() {
        return retCode;
    }
    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }
    public String getRetMsg() {
        return retMsg;
    }
    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
}
