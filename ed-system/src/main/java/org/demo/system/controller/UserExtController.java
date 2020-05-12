package org.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.system.service.user.UserExtService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.user.LecturerAudit;
import pojo.user.UserExt;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "UserExtController" , tags = "学员管理接口")
public class UserExtController {

    @Resource
    UserExtService userExtService;

    //根据条件查询学员信息
    @ApiOperation(value = "查询学员信息" , notes = "1.查询全部用户</br>2.根据条件查询审核信息[昵称、手机号、状态、注册时间]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "userName" , value = "用户昵称"),
            @ApiImplicitParam(paramType = "query" , name = "mobile" , value = "手机号码" ),
            @ApiImplicitParam(paramType = "query" , name = "status" , value = "状态"),
            @ApiImplicitParam(paramType = "query" , name = "createDate" , value = "注册时间"),
            @ApiImplicitParam(paramType = "query" , name = "createDateTwo" , value = "注册时间(到期时间)")
    })
    @GetMapping("/user/list/findByAll")
    public Dto findByAll(@RequestParam(value = "userName" , required = false) String userName ,
                         @RequestParam(value = "mobile" , required = false) String mobile ,
                         @RequestParam(value = "status" , required = false) String status ,
                         @RequestParam(value = "createDate" , required = false) String createDate,
                         @RequestParam(value = "createDateTwo" , required = false) String createDateTwo) throws ParseException {

        //判断数据
        UserExt userExt = new UserExt();
        userExt.setNickname(userName);
        userExt.setMobile(mobile);
        if(createDate != null && !createDate.equals("")){
            userExt.setGmtCreate(createDate);
        }
        if(createDateTwo != null && !createDateTwo.equals("")){
            userExt.setGmtModified(createDateTwo);
        }
        if(status != null && !status.equals("")){
            userExt.setStatusId(Integer.parseInt(status));
        }

        List<UserExt> findByALL = userExtService.findAll(userExt);
        if(findByALL.size() == 0){
            return DtoUtil.returnSuccess("未查询到用户数据!!");
        }

        return DtoUtil.returnDataSuccess(findByALL);
    }

    //修改用户信息
    @ApiOperation(value = "修改用户信息" , notes = "修改用户信息")
    @PostMapping("/user/list/updateUserInfo")
    public Dto updateUserInfo(@RequestBody UserExt userExt){
        //日期转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        userExt.setGmtModified(format.format(new Date()));

        int count = userExtService.updateUserExtInfo(userExt);
        if(count < 0){
            return DtoUtil.returnFail("修改失败!!" , "20020");
        }

        return DtoUtil.returnSuccess("修改成功!!");
    }


//    {
//        "age": 20,
//            "id": 3,
//            "mobile": "18273006518",
//            "nickname": "小殇",
//            "remark": "测试用户-小殇",
//            "sex": 2
//    }
}
