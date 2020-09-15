package com.liugui.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("SYS_USER")
public class SysUser {
    @TableId
    private int userId;
    private String userName;
    private int userSex;
    private int userAge;
    @TableLogic
    private int isDelete;
}
