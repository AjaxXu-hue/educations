package com.login.utils;

import org.springframework.data.redis.core.RedisTemplate;
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

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //根据key获取值
    public Object get(String key){
        Object codeInfo = redisTemplate.opsForValue().get(key);
        return codeInfo;
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //根据Key删除redis中的信息(传入一个或多个信息)
    public void del(String... key){
        if(key != null && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    //GET SET 判断是否存在(exists) 有效期(ttl) del

//    public JedisPool jedisPool;
//
//    public JedisPool getJedisPool() {
//        return jedisPool;
//    }
//
//    public void setJedisPool(JedisPool jedisPool) {
//        this.jedisPool = jedisPool;
//    }
//
//    //get(根据连接池获取某个实例)
//    public String get(String key){
//        String value = null;
//        Jedis jedis = null;
//        try{
//            jedis = jedisPool.getResource();
//            value = jedis.get(key);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
////        finally{
////            返还到连接池
////            returnResource(jedisPool, jedis);
////        }
//
//        return value;
//    }
//
//    //set
//    public Boolean set(String key , String value){
//        try{
//            Jedis jedis = jedisPool.getResource();
//            jedis.set(key , value);
//            return true;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//    //重载
//    public Boolean set(String key , int expice , String value){
//        try{
//            Jedis jedis = jedisPool.getResource();
//            jedis.setex(key, expice, value);
//            return true;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    //判断是否存在
//    public boolean exists(String key){
//        Jedis jedis = jedisPool.getResource();
//        //判断是否存在
//        Boolean result = jedis.exists(key);
//        return result;
//    }
//
//    //判断过期时间
//    public long ttl(String key){
//        Jedis jedis = jedisPool.getResource();
//        //判断过期时间
//        long result = jedis.ttl(key);
//        return result;
//    }
//
//    //del
//    public Long del(String key){
//        Jedis jedis = jedisPool.getResource();
//        //del
//        long result = jedis.del(key);
//        return result;
//    }
}
