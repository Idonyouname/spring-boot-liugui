package com.liugui.springbootcache.service;

import com.liugui.springbootcache.model.UserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserService
 * @Author: liugui
 * @Date: 2020-06-30 16:59
 **/
public interface UserService  {

    int save(UserDo userDo)throws Exception;
    int delete(Integer userId)throws Exception;
    int update(UserDo userDo)throws Exception;
    UserDo selectOne(Integer userId);
    List<UserDo> selectListByMap(Map map);
    List<UserDo> selectByStr(@Param("str") String str);

}
