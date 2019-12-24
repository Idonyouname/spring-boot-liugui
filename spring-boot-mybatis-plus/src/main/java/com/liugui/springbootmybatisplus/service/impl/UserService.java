package com.liugui.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugui.springbootmybatisplus.mapper.UserMapper;
import com.liugui.springbootmybatisplus.model.SysUser;
import com.liugui.springbootmybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: UserService
 * @Author: liugui
 * @Date: 2019-12-24 10:38
 **/
@Service
public class UserService extends ServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<SysUser> selectPageVo(Page page, String userName) {
        return userMapper.selectPageVo(page,userName);
    }
}
