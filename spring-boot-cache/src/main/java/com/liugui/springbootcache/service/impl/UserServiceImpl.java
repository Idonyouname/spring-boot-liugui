package com.liugui.springbootcache.service.impl;

import com.liugui.springbootcache.mapper.UserMapper;
import com.liugui.springbootcache.model.UserDo;
import com.liugui.springbootcache.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Author: liugui
 * @Date: 2020-06-30 17:00
 **/

/**
 * 全局配置缓存，比如配置缓存的名字（cacheNames),
 * 只需要在类上配置一次，下面的方法就默认以全局配置为主，不需要二次配置
 */
@CacheConfig(cacheNames = "userCache")
@Service
public class UserServiceImpl  implements UserService {


    @Resource
    private UserMapper userMapper;

    /**
     * 注解 它总是会把数据缓存，而不会去每次做检查它是否存在，
     * 相比之下它的使用场景就比较少，毕竟我们希望并不是每次都把所有的数据都给查出来，
     * 我们还是希望能找到缓存的数据，直接返回，这样能提升我们的软件效率。
     */
    @CachePut
    @Override
    public int save(UserDo userDo) throws Exception {
        return userMapper.save(userDo);
    }

    @CacheEvict(allEntries = true)
    @Override
    public int delete(Integer userId) throws Exception {
        return userMapper.delete(userId);
    }

    /**
     * 主要是配合@Cacheable一起使用的，它的主要作用就是清除缓存，
     * 当方法进行一些更新、删除操作的时候，这个时候就要删除缓存。
     */
    @CacheEvict(allEntries = true)
    @Override
    public int update(UserDo userDo) throws Exception {
        return userMapper.update(userDo);
    }

    @Override
    public UserDo selectOne(Integer userId) {
        return userMapper.selectOne(userId);
    }

    /**
     * 主要实现的功能再进行一个读操作的时候。就是先从缓存中查询，
     * 如果查找不到，就会走数据库的执行方法，
     * 这是缓存的注解最重要的一个方法，基本上我们的所有缓存实现都要依赖于它。
     */
    @Cacheable
    @Override
    public List<UserDo> selectListByMap(Map map) {
        try {
            //模拟耗时
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectListByMap(map);
    }

    @Override
    public List<UserDo> selectByStr(String str) {
        return userMapper.selectByStr(str);
    }
}
