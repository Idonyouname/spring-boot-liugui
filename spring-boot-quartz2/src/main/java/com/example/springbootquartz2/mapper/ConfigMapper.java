package com.example.springbootquartz2.mapper;

import com.example.springbootquartz2.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: ConfigMapper
 * @Author: liugui
 * @Date: 2020-09-18 11:31
 **/
@Mapper
public interface ConfigMapper {
    @Select("select id,cron from config where id = #{id} ")
    Config findOne(Integer id);
}
