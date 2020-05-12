package org.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.system.service.lecturer.LecturerAuditService;
import org.demo.system.service.lecturer.LecturerService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.user.Lecturer;
import pojo.user.LecturerAudit;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "LecturerAuditController" , tags = "讲师信息-审核接口")
public class LecturerAuditController {

    @Resource
    LecturerAuditService lecturerAuditService;//讲师信息-审核

    @Resource
    LecturerService lecturerService;//讲师表

    //查询讲师信息(审核)
    @ApiOperation(value = "查询讲师信息(审核)" , notes = "1.查询全部用户 2.根据条件查询审核信息[名称、手机号、状态、审核情况]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "leName" , value = "讲师名称" , required = false),
            @ApiImplicitParam(paramType = "query" , name = "mobile" , value = "手机号码" ),
            @ApiImplicitParam(paramType = "query" , name = "status" , value = "状态" , defaultValue = "1"),
            @ApiImplicitParam(paramType = "query" , name = "audit" , value = "审核状态" )
    })
    @GetMapping("/lecturer/list/audit/findByAll")
    public Dto findByAll(@RequestParam(value = "leName" , required = false) String leName ,
                         @RequestParam(value = "mobile" , required = false) String mobile ,
                         @RequestParam(value = "status" , required = false) String status ,
                         @RequestParam(value = "audit" , required = false) String audit){

        //判断数据
        LecturerAudit lecturerAudit = new LecturerAudit();
        lecturerAudit.setLecturerName(leName);
        lecturerAudit.setLecturerMobile(mobile);
        if(status != null && !status.equals("")){
            lecturerAudit.setStatusId(Integer.parseInt(status));
        }
        if(audit != null && !audit.equals("")){
            lecturerAudit.setAuditStatus(Integer.parseInt(audit));
        }

        List<LecturerAudit> findByALL = lecturerAuditService.findAll(lecturerAudit);
        if(findByALL.size() == 0){
            return DtoUtil.returnSuccess("未查询到教师审核数据!!");
        }

        return DtoUtil.returnDataSuccess(findByALL);
    }

    //审核讲师信息
    @ApiOperation(value = "审核讲师信息" , notes = "1.审核通过 2.审核不通过")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "id" , value = "编号"),
            @ApiImplicitParam(paramType = "query" , name = "auditStatus" , value = "审核结果"),
            @ApiImplicitParam(paramType = "query" , name = "opinion" , value = "审核意见" )
    })
    @PostMapping("/lecturer/list/audit/updateAudit")
    public Dto updateAudit(@RequestParam(value = "id" , required = false) String id ,
                           @RequestParam(value = "auditStatus" , required = false) String auditStatus ,
                           @RequestParam(value = "opinion" , required = false) String opinion){
        //判断审核状态
        if(auditStatus.equals("7")){
            //通过
            //查询讲师信息
            LecturerAudit lecturerAudit = lecturerAuditService.findById(Long.parseLong(id));
            //赋值
            Lecturer lecturer = new Lecturer();
            lecturer.setLecturerUserNo(lecturerAudit.getLecturerUserNo());
            lecturer.setLecturerName(lecturerAudit.getLecturerName());
            lecturer.setLecturerMobile(lecturerAudit.getLecturerMobile());
            lecturer.setLecturerEmail(lecturerAudit.getLecturerEmail());
            lecturer.setPosition(opinion);
            lecturer.setHeadImgUrl(lecturerAudit.getHeadImgUrl());
            lecturer.setIntroduce(lecturerAudit.getIntroduce());
            lecturer.setLecturerProportion(lecturerAudit.getLecturerProportion());
            lecturer.setStatusId(lecturerAudit.getStatusId());
            lecturer.setGmtCreate(new Date());
            lecturer.setGmtModified(new Date());

            //添加信息(讲师表)
            int count = lecturerService.insertLecturerInfo(lecturer);

            //删除信息(讲师审核表)
            count = lecturerAuditService.deleteById(Long.parseLong(id));
            if(count < 0){
                return DtoUtil.returnFail("通过失败" , "10040");
            } else {
                //发送邮件
            }
        } else {
            //不通过
            //判断是否填写审核意见
            if(opinion == null && opinion.equals("")){
                return DtoUtil.returnSuccess("请填写审核意见");
            }
            //改变状态
            LecturerAudit lecturerAudit = new LecturerAudit();
            lecturerAudit.setId(Long.parseLong(id));
            lecturerAudit.setAuditStatus(Integer.parseInt(auditStatus));
            lecturerAudit.setAuditOpinion(opinion);
            int count = lecturerAuditService.updateAuditInfo(lecturerAudit);

            if(count > 0){
                //发送邮件
            } else {
                return DtoUtil.returnFail("状态修改失败" , "10040");
            }
        }

        return DtoUtil.returnSuccess("审核完成!!");
    }

}
