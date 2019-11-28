package com.liugui.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugui.springbootmybatisplus.model.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserMapper
 * @Author: liugui
 * @Date: 2019-11-27 17:02
 **/
public interface UserMapper extends BaseMapper<SysUser> {
    /**
     * <p>
     * 查询 : 根据userName 名字查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param userName 名字
     * @return 分页对象
     */
    IPage<SysUser> selectPageVo(Page page, @Param("userName") String userName);
}
