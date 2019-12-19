package com.liugui.springbootvalid.controller;

import com.liugui.springbootvalid.model.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: UserController
 * @Author: liugui
 * @Date: 2019-12-19 11:52
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 单参数效验
     */
    @RequestMapping("/removeUserVo")
    public String removeUserVo(@Valid @NotNull(message = "传入参数不能为空") Integer id){
        return "操作成功 " + id;
    }

    /**
     * 分组效验
     */
    @RequestMapping("/addUserVo")
    public String addUserVo(@Validated({UserVO.Add.class}) @RequestBody UserVO userVO){
        return "操作成功" + userVO;
    }

    /**
     * 分组效验
     */
    @RequestMapping("/editUserVo")
    public String editUserVo(@Validated({UserVO.Update.class}) @RequestBody UserVO userVO){
        return "操作成功" + userVO;
    }

}
