package com.liugui.springbooth2database.mapper;

import com.liugui.springbooth2database.model.UserDo;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName: UserMapper
 * @Author: liugui
 * @Date: 2019-11-27 15:49
 **/
@Mapper
public interface UserMapper  {

    int save(UserDo userDo)throws Exception;

    @Delete("delete from sys_user where user_id = #{id} ")
    int delete(Integer id) throws Exception;


    int update(UserDo userDo)throws Exception;

    @Select("select * from sys_user where user_id = #{id} ")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name")
    })
    UserDo selectById(Integer id);

}
