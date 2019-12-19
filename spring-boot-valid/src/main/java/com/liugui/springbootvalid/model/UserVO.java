package com.liugui.springbootvalid.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * @ClassName: UserVO
 * @Author: liugui
 * @Date: 2019-12-19 11:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

    public interface Add{}
    public interface Update{}

    //用户id
    @NotNull(groups = Update.class,message = "用户id不能为空")
    private Integer id;
    //用户名
    @NotNull(groups = Add.class,message = "用户名不能为空")
    private String userName;
    //用户密码
    private String password;
    //用户手机

    @Pattern(groups = {Add.class,Update.class},regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$",message = "手机号格式不正确")
    private String telephone;
    //用户邮箱

    @Email(groups = {Add.class,Update.class},message = "不符合邮箱格式")
    private String email;
    //用户身份证

    @Pattern(groups = {Add.class,Update.class},regexp = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)" +
            "|" +
            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)", message = " 身份证格式不正确")
    private String idNo;
    //年龄
    @Digits(groups = {Add.class,Update.class},integer = 3,fraction = 0,message = "目前年龄值最大不超过3位数整数")
    @Max(groups = {Add.class,Update.class},value = 150,message = "年龄当前不支持超过150")
    private Integer age;
    //性别
    @Range(groups = {Add.class,Update.class},min = 0,max = 1,message = "性别传入值1或者0")
    private String sex;
    //创建时间
    private String createTime;
    //创建人
    private String sender;
    //备注信息
    private String comment;

}
