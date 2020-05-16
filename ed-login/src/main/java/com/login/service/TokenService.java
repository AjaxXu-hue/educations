package com.login.service;


import pojo.user.User;
import pojo.user.UserExt;

public interface TokenService {

    //生成Token值(userAgent = 用户ID)
    String getToken(String userAgent, User user);

    //保存(键值对)
    void save(String token, User user);

    //判断是否存在
    boolean validate(String token, String userAgent);

    //删除token
    void deleteToken(String token);

    //置换
    void reloadToken(String userAgent, String Token);
}
