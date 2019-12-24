package com.liugui.springbootmybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liugui.springbootmybatisplus.model.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: IUserService
 * @Author: liugui
 * @Date: 2019-12-24 10:37
 **/
public interface IUserService extends IService {
    IPage<SysUser> selectPageVo(Page page, @Param("userName") String userName);
}
