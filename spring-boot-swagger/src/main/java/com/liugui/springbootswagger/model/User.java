package com.liugui.springbootswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: User
 * @Author: liugui
 * @Date: 2019-12-09 14:05
 **/
@Data
@ApiModel
public class User {
    @ApiModelProperty("用户id")
    private Integer id;
    private String name;
    private String role;
    private String title;
    private Integer age;
    private String createTime;
    private Integer sender;
}
