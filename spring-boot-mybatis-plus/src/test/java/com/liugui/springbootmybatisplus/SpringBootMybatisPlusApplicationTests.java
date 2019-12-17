package com.liugui.springbootmybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugui.springbootmybatisplus.mapper.UserMapper;
import com.liugui.springbootmybatisplus.model.SysUser;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectByPage(){
        this.start();
        Page<SysUser> page = new Page<>();
        page.setCurrent(1);
        page.setSize(2);
        IPage<SysUser> sysUserIPage = userMapper.selectPageVo(page,"liugui");
        System.out.println(sysUserIPage);
        List<SysUser> userDoList = sysUserIPage.getRecords();
        userDoList.forEach(System.out::println);
        this.end();
    }


    @Test
    public void testSelect(){
        this.start();
        List<SysUser>  userDoList = userMapper.selectList(null);
        userDoList.forEach(System.out::println);
        this.end();
    }

    @Test
    public void addUser() {
        this.start();
        SysUser sysUser = new SysUser();
        sysUser.setUserId(7);
        sysUser.setUserName("liugui6");
        sysUser.setUserAge(20);
        sysUser.setUserSex(1);
        int addUserFlag = userMapper.insert(sysUser);
        Assert.assertEquals(1,addUserFlag);
        this.end();
        this.testSelect();
    }

    private void start(){
        System.out.println("===================start================");
    }

    private void end(){
        System.out.println("===================end=================");
    }
}
