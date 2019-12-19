package com.liugui.springbootvalid.model;

import java.io.Serializable;

public class Msg<T> implements Serializable {
    //执行状态 1表示成功 2表示失败
    private String state;

    //返回的提示语
    private String code;

    //返回的数据
    private T data;

    public Msg success(){
        this.state ="1";
        return  this;
    }

    public Msg fail(){
        this.state ="2";
        return  this;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public Msg setCode(String code) {
        this.code = code;
        return  this;
    }

    public boolean isSuccess() {
        return "1".equals(this.state);
    }

    public T getData() {
        return data;
    }

    public Msg setData(T data) {
        this.data = data;
        return  this;
    }
}
