package com.system.controller;

import com.system.service.lecturer.LecturerService;
import com.system.service.lecturer.LecturerExtService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.user.Lecturer;
import pojo.user.LecturerExt;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.*;

//讲师管理
@RestController
public class LecturerController {

    @Resource
    LecturerService lecturerService;//讲师详细列表

    @Resource
    LecturerExtService lecturerExtService;//讲师账户信息表

    //查询 讲师列表 (讲师名称、手机号、状态)
    @GetMapping("/lecturer/list/lec/findByAll")
    public Dto listFindByAll(@RequestParam(value = "leName" , required = false) String leName ,
                             @RequestParam(value = "mobile" , required = false) String mobile ,
                             @RequestParam(value = "status" , required = false) String status){

        Lecturer lecturer = new Lecturer();
        //判断数据
        if(leName != null && !leName.equals("")){
            lecturer.setLecturerName(leName);
        }
        if(mobile != null && !mobile.equals("")){
            lecturer.setLecturerMobile(mobile);
        }
        if(status != null && !status.equals("")){
            lecturer.setStatusId(Integer.parseInt(status));
        }

        //数据查询
        List<Lecturer> findAll = lecturerService.findAll(lecturer);
        if(findAll.size() == 0){
            return DtoUtil.returnSuccess("未查询到数据");
        }
        return DtoUtil.returnDataSuccess(findAll);
    }

    //根据ID查询用户
    @GetMapping("/lecturer/list/lec/update/findById")
    public Dto listFindById(@RequestParam(value = "id") String id){

        Map mapInfo = new HashMap();

        Lecturer lecturer = lecturerService.findById(Long.parseLong(id));

        //根据 讲师用户编号 查看用户银行信息
        System.out.println(lecturer.getLecturerUserNo());
        LecturerExt lecturerExt = lecturerExtService.findById(lecturer.getLecturerUserNo());

        if(lecturer != null){
            mapInfo.put("lecturer",lecturer);
        } else {
            return DtoUtil.returnSuccess("未查询到用户信息");
        }
        if(lecturerExt != null){
            mapInfo.put("lecturerExt" , lecturerExt);
        } else {
            return DtoUtil.returnSuccess("未查询到用户银行卡信息");
        }

        return DtoUtil.returnDataSuccess(mapInfo);
    }

    //修改讲师信息
    @PostMapping("/lecturer/list/lec/update/updateInfo")
    public Dto updateInfo(@RequestBody Lecturer lecturer){
        lecturer.setGmtModified(new Date());

        int count = lecturerService.updateLecturerInfo(lecturer);
        if(count > 0){
            return DtoUtil.returnSuccess("修改成功!!");
        }

        return DtoUtil.returnSuccess("修改失败!!");
    }

    //修改分成
    @PostMapping("/lecturer/list/lec/update/profit")
    public Dto profit(@RequestBody Lecturer lecturer){

        int count = lecturerService.updateLecturerInfo(lecturer);
        if(count > 0){
            return DtoUtil.returnSuccess("修改成功!!");
        }

        return DtoUtil.returnSuccess("修改失败!!");
    }

    //连接禁用(启用) [软删除]
}
