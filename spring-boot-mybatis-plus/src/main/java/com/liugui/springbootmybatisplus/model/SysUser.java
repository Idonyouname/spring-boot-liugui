package com.liugui.springbootmybatisplus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: user
 * @Author: liugui
 * @Date: 2019-11-27 15:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private int userId;
    private String userName;
    private int userSex;
    private int userAge;
}
