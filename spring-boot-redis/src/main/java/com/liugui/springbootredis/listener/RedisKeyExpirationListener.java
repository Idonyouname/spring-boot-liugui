package com.liugui.springbootredis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 *
 * @ClassName: RedisKeyExpirationListener
 * @Author: liugui
 * @Date: 2020-04-17 09:43
 **/
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /*
     * redis.conf 需要 配置 notify-keyspace-events Ex
     * 含义为：发布key事件，使用过期事件（当每一个key失效时，都会生成该事件）
     */

    /**
     * 针对redis失效事件 进行业务处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取到失效的 key，进行业务处理
        String expiredKey = message.toString();
        System.out.println("失效的key：" + expiredKey);
    }
}
