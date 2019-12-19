package com.liugui.springbootvalid.controller;

import com.liugui.springbootvalid.model.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Author: liugui
 * @Date: 2019-12-19 11:52
 **/
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    /**
     * 利用全局异常拦截 抛出异常 将自定义message信息返给用户
     * @NotBlank  应用于String
     * @NotNull  应用于integer
     * @NotEmpty 用在集合类上面
     */

    /**
     * 单参数 @NotBlank 效验
     */
    @RequestMapping("/findUserVoByMap")
    public String findUserVoByMap(@NotEmpty(message = "传入参数不能为空") @RequestBody Map<String,Object> map){
        return "操作成功 " + map;
    }

    /**
     * 单参数 @NotBlank 效验
     */
    @RequestMapping("/selectUserVoById")
    public String selectUserVoById(@NotBlank(message = "传入参数不能为空") String name){
        return "操作成功 " + name;
    }

    /**
     * 单参数 @NotNull 效验
     */
    @RequestMapping("/removeUserVo")
    public String removeUserVo(@NotNull(message = "传入参数不能为空") Integer id){
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
