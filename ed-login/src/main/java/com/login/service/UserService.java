package com.login.service;

import org.apache.ibatis.annotations.Param;
import pojo.user.User;

import java.util.List;

/**
 * 用户基本信息(User)表数据库访问层
 */
public interface UserService {

    //通过ID查询单条数据(登录操作)
    User findByNameAndPass(User user);

    //通过实体作为筛选条件查询
    List<User> findAll(User user);

    //新增数据
    int insertUserInfo(User user);

    //修改数据
    int updateUserInfo(User user);

    //通过主键删除数据
    int deleteById(Long id);

    //发送邮箱/(邮箱注册)
    void validateCode(String email);

    //短信发送/(短信发送)
    void phoneCode(String phoneCode);

    //验证码验证
    boolean testCode(String emailOrMobile , String code);


}