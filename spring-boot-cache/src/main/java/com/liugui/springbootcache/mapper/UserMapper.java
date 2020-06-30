package com.liugui.springbootcache.mapper;

import com.liugui.springbootcache.model.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserMapper
 * @Author: liugui
 * @Date: 2019-11-27 15:49
 **/
@Mapper
public interface UserMapper  {
    int save(UserDo userDo)throws Exception;
    int delete(Integer userId)throws Exception;
    int update(UserDo userDo)throws Exception;
    UserDo selectOne(Integer userId);
    List<UserDo> selectListByMap(Map map);
    List<UserDo> selectByStr(@Param("str") String str);
}
