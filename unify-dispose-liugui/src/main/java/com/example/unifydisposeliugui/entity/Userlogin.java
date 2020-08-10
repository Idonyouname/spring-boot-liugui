package com.example.unifydisposeliugui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lg
 * @since 2020-08-10
 */
public class Userlogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userID;

    @TableField("userName")
    private String userName;

    private String password;

    /**
     * 角色权限
     */
    private Integer role;


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Userlogin{" +
        "userID=" + userID +
        ", userName=" + userName +
        ", password=" + password +
        ", role=" + role +
        "}";
    }
}
