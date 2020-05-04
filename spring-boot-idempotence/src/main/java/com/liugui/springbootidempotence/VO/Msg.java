package com.liugui.springbootidempotence.VO;

import java.io.Serializable;

/**
 * @ClassName: Msg
 * @Author: liugui
 * @Date: 2020-05-04 17:23
 **/
public class Msg<T> implements Serializable {

    private String state;


    private String code;


    private T data;

    private Integer num;

    public Integer getNum() {
        return num;
    }

    public Msg setNum(Integer num) {
        this.num = num;
        return this;
    }

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

    public T getData() {
        return data;
    }

    public Msg setData(T data) {
        this.data = data;
        return  this;
    }
}
