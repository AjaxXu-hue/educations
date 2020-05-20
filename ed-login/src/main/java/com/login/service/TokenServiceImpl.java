package com.login.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.login.utils.RedisAPI;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Service;
import pojo.user.User;
import springfox.documentation.spring.web.json.Json;
import utils.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class TokenServiceImpl implements TokenService{

    @Resource
    RedisAPI redisAPI;

    @Override
    //生成Token
    public String getToken(String userAgent , User user) {
        StringBuilder str = new StringBuilder();
        str.append("token:");

        //获取设备类型
        UserAgent agent = UserAgent.parseUserAgentString(userAgent);
        if(agent.getOperatingSystem().isMobileDevice()){
            str.append("MOBILE-");
        } else {
            str.append("PC-");
        }

        //加密
        str.append(MD5.getMd5(user.getUserNo().toString() , 32)+ "-");
        str.append(user.getId()+ "-");
        str.append(MD5.getMd5(userAgent , 6));
        return str.toString();
    }

    @Override
    //保存Token
    public void save(String token , User user) {
        //分移动端和pc端
        if(token.startsWith("token:PC-")){
            redisAPI.set(token , JSONObject.toJSONString(user), 120*60);
        } else {
            redisAPI.set(token , JSON.toJSONString(user) , 0);
        }
    }

    @Override
    //验证token是否有效
    public boolean validate(String token, String userAgent) {
        //判断是否存在
        if(!redisAPI.hasKey(token)){
            return false;
        }
        return true;
    }

    @Override
    //删除
    public void deleteToken(String token) {
        redisAPI.del(token);
    }

    @Override
    //置换
    public void reloadToken(String userAgent, String Token) {

    }
}
