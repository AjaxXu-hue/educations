package org.order.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

//redis工具类
@Component
public class RedisAPI {

    //(对象操作)
    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                stringRedisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //根据key获取值
    public Object get(String key){
        Object codeInfo = stringRedisTemplate.opsForValue().get(key);
        return codeInfo;
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return stringRedisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //根据Key删除redis中的信息(传入一个或多个信息)
    public void del(String... key){
        if(key != null && key.length > 0){
            if(key.length == 1){
                stringRedisTemplate.delete(key[0]);
            } else {
                stringRedisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 根据KEY获取保存时间
     */
    public Long time(String key){
        return stringRedisTemplate.opsForValue().getOperations().getExpire(key);
    }

    /**
     * 递减
     * @param key 键
     * @return
     */
    public Boolean decr(String key) {
        Long time=time(key);
        int i=Integer.parseInt(stringRedisTemplate.opsForValue().get(key))-1;
        if(i>0){
            this.set(key,String.valueOf(i),time);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 递增
     * @param key 键
     * @return
     */
    public Boolean insert(String key) {
        Long time=time(key);
        int i=Integer.parseInt(stringRedisTemplate.opsForValue().get(key))+1;
        this.set(key,String.valueOf(i),time);
        return true;
    }
}
