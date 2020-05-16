package com.login.service;

import com.login.utils.RedisAPI;
import mapper.user.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import pojo.user.User;
import utils.MD5;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 用户基本信息(User)表数据库访问层
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Resource
    MailService mailService;//邮件发送接口

    @Resource
    SmsService smsService;//短信发送接口

    @Resource
    RedisAPI redisAPI;//redis非关系型数据库

    //通过电话号码/密码查询单条数据(登录操作)
    @Override
    public User findByNameAndPass(User user) {
        return userMapper.findByNameAndPass(user);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<User> findAll(User user) {
        return userMapper.findAll(user);
    }

    //新增
    @Override
    public int insertUserInfo(User user) {
        return userMapper.insertUserInfo(user);
    }

    //修改
    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    //删除
    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    //发送邮箱/(邮箱注册)
    @Override
    public void validateCode(String email) {
        //生成激活码
        String code = MD5.getMd5(new Date().toLocaleString() , 32);
        //发送邮件 发送人、收件人、抄送人、邮件主题、邮件内容
        mailService.sendMail("1442148219@qq.com" , email , "1453780678@qq.com" ,
                "领课教育注册码" , code);
        // 激活码存入redis中
        redisAPI.set("activation:"+email , code , 30*60);
    }

    //发送短信/(邮箱注册)
    @Override
    public void phoneCode(String phone) {
        //生成随机数(产生验证码)
        int max = 99999;
        int min = 11111;
        Random random = new Random();
        int code = random.nextInt(max)%(max-min+1) + min;

        //发送验证码 (发送号码 ， 测试接口 ， 发送内容(两分钟有效))
        smsService.send(phone , "1" , new String[]{String.valueOf(code),"2"});

        //缓存验证码到redis(120秒)
        boolean ss = redisAPI.set("activation:"+phone , String.valueOf(code) ,120);
    }

    /*
    验证码验证(电话号码/邮箱，验证码)
     */
    public boolean testCode(String emailOrMobile , String code){
        //更新验证码 activation:(开头)
        String key = "activation:"+emailOrMobile;//获取key值
        String value = (String) redisAPI.get(key);//根据key值查询
        if(null != value && value.equals(code)){
            return true;
        }
        return false;
    }
}