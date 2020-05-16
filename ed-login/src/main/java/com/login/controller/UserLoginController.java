package com.login.controller;

import com.login.service.TokenService;
import com.login.service.UserExtService;
import com.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.com.UserTokenVO;
import pojo.user.User;
import pojo.user.UserExt;
import utils.DtoUtil;
import utils.MD5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@Api(value = "/userApi", tags = "用户登录验证接口")
public class UserLoginController {

    @Resource
    UserService userService;//用户表

    @Resource
    UserExtService userExtService;//用户扩展表

    @Resource
    TokenService tokenService;

    //登录验证user-agent UserTokenVO(返回的数据) Calendar
    @ApiOperation(value = "登录验证", notes = "登录验证")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobileOrEmail", value = "电话号码或者邮箱"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码")})
    @GetMapping("/doLoginInUser")
    public Dto loginUser(@RequestParam(value = "mobileOrEmail") String mobileOrEmail,
                         @RequestParam(value = "password") String password,
                         HttpServletRequest request) {
        //验证邮箱或密码
        User user = new User();
        //验证邮箱
        Boolean flag = testEmail(mobileOrEmail);
        if(!flag){
            //验证手机号
            Boolean flag2 = testPhone(mobileOrEmail);
            if(!flag2){
                return DtoUtil.returnFail("格式验证失败" , "10000");
            } else {
                user.setMobile(mobileOrEmail);
            }
        } else {
            user.setEmail(mobileOrEmail);
        }
        //是否查询到用户
        User userInfo = userService.findByNameAndPass(user);
        if (null != userInfo) {
            //匹配密码
            String pass = MD5.getMd5(password , 32);//密码
            user.setMobileSalt(pass);
            //查询
            userInfo = userService.findByNameAndPass(user);
            if(null != userInfo){
                //登录成功生成TOKEN
                String userAgent = request.getHeader("user-agent");
                String token = tokenService.getToken(userAgent, userInfo);
                //保存redis
                tokenService.save(token, userInfo);

                //传送给客户端
                UserTokenVO tokenVo = new UserTokenVO(token,
                        Calendar.getInstance().getTimeInMillis() + 2 * 60 * 60 * 1000,
                        Calendar.getInstance().getTimeInMillis());
                return DtoUtil.returnDataSuccess(tokenVo);
            } else {
                return DtoUtil.returnFail("密码错误", "30020");
            }
        } else {
            return DtoUtil.returnFail("用户名不存在", "30010");
        }
    }

    //注销
    @ApiOperation(value = "用户注销",httpMethod = "GET", protocols = "HTTP", produces = "application/json",
            response = Dto.class,notes="客户端需在header中发送token")
    @ApiImplicitParam(paramType="header",required=true,name="token",value="用户认证Token")
    @GetMapping("/loginOut")
    public Dto loginOut(HttpServletRequest request) {
        //获取token值
        String token = request.getHeader("token");
        //验证是否存在
        if (tokenService.validate(token, request.getHeader("user-agent"))) {
            //存在删除token
            tokenService.deleteToken(token);
            return DtoUtil.returnSuccess("用户退出成功");
        } else {
            return DtoUtil.returnFail("token无效", "30029");
        }
    }


    //邮箱注册/手机注册（发送注册码）
    @ApiOperation(value = "邮箱注册/手机注册（发送注册码）", notes = "发送注册码")
    @ApiImplicitParam(paramType = "query", name = "mobileOrEmail", value = "电话号码或者邮箱")
    @GetMapping("/validateCode")
    public Dto validateCode(@RequestParam(value = "mobileOrEmail") String mobileOrEmail) {
        //验证邮箱
        Boolean flag = testEmail(mobileOrEmail);
        if(!flag){
            //验证手机号
            Boolean flag2 = testPhone(mobileOrEmail);
            if(!flag2){
                return DtoUtil.returnFail("格式验证失败" , "10000");
            } else {
                //短信发送
                userService.phoneCode(mobileOrEmail);
                return DtoUtil.returnSuccess("短信发送成功!!");
            }
        } else {
            //发送邮箱注册码
            userService.validateCode(mobileOrEmail);
            return DtoUtil.returnSuccess("邮件发送发送成功!!");
        }
    }


    //用户注册  邮箱注册/手机注册
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobileOrEmail", value = "电话号码或者邮箱"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码"),
            @ApiImplicitParam(paramType = "query", name = "code", value = "验证码")})
    @GetMapping("/regisUser")
    public Dto regisUser(@RequestParam(value = "mobileOrEmail") String mobileOrEmail,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "code") String code) {
        //验证码验证
        if(!userService.testCode(mobileOrEmail , code)){
            return DtoUtil.returnSuccess("验证码输入错误!!");
        }
        //验证邮箱或密码
        User user = new User();
        //验证邮箱
        Boolean flag = testEmail(mobileOrEmail);
        if(!flag){
            //验证手机号
            Boolean flag2 = testPhone(mobileOrEmail);
            if(!flag2){
                return DtoUtil.returnFail("格式验证失败" , "10000");
            } else {
                user.setMobile(mobileOrEmail);
            }
        } else {
            user.setEmail(mobileOrEmail);
        }
        //密码加密
        user.setMobileSalt(MD5.getMd5(password,32));
        //登录密码
        user.setMobilePsw(password);
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        //生成用户编号
        user.setUserNo(Long.parseLong(userNo().toString()));

        int count = userService.insertUserInfo(user);
        if(count < 0){
            return DtoUtil.returnSuccess("新增失败!!");
        }

        return DtoUtil.returnSuccess("新增成功!!");
    }


    //验证合法的手机号
    private boolean testPhone(String phone) {
        String regex = "^1[3578]{1}\\d{9}$";
        return Pattern.compile(regex).matcher(phone).find();
    }

    //验证合法的邮箱
    private boolean testEmail(String email) {
        String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return Pattern.compile(regex).matcher(email).find();
    }

    //生成唯一用户ID
    public String userNo(){
        //获取年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        //获取时间戳
        String time=dateFormat.format(new Date());
        //生成6位随机数
        int ran = (int)((Math.random()*9+1)*100000);
        return time+ran;
    }

}

