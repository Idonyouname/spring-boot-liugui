package com.liugui.springbootadvice.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一响应实体类
 * @ClassName: Response
 * @Author: liugui
 * @Date: 2020-03-25 10:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T>  implements Serializable {


    //执行状态 1表示成功 2表示失败
    private String state;

    //返回的提示语
    private String code;

    //返回的数据
    private T data;

    public Response<T> success(){
        this.state ="1";
        return  this;
    }

    public Response<T> fail(){
        this.state ="2";
        return  this;
    }

    public Response<T> code(String code) {
        this.code = code;
        return  this;
    }

    public Response<T> data(T data) {
        this.data = data;
        return  this;
    }


}
