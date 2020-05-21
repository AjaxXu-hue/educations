package pojo.org.leRun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.com.InsertLeAudit;
import pojo.org.leRun.service.LecturerAuditService;
import pojo.user.Lecturer;
import pojo.user.LecturerAudit;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Api(value = "LecturerAuditController" , tags = "讲师接口")
public class LeAuditController {

    @Resource
    LecturerAuditService lecturerAuditService;

    //讲师申请(讲师申请)
    @ApiOperation(value = "讲师申请" , notes = "讲师申请")
    @PostMapping("/leInfo/insertInfo")
    public Dto updateInfo(InsertLeAudit insertLeAudit){
        LecturerAudit lecturerAudit = new LecturerAudit();
        lecturerAudit.setGmtModified(new Date());
        lecturerAudit.setGmtCreate(new Date());
        lecturerAudit.setLecturerName(insertLeAudit.getLecturerName());
        lecturerAudit.setLecturerMobile(insertLeAudit.getLecturerMobile());
        lecturerAudit.setPosition(insertLeAudit.getPosition());
        lecturerAudit.setLecturerEmail(insertLeAudit.getLecturerEmail());
        lecturerAudit.setIntroduce(insertLeAudit.getIntroduce());
        lecturerAudit.setHeadImgUrl(insertLeAudit.getHeadImgUrl());
        lecturerAudit.setSort(insertLeAudit.getSort());
        lecturerAudit.setLecturerProportion(Double.parseDouble(insertLeAudit.getLecturerProportion()));
        //讲师编号生成
        lecturerAudit.setLecturerUserNo(insertLeAudit.getLecturerUserNo());

        int count = lecturerAuditService.insertAuditInfo(lecturerAudit);
        if(count > 0){
            return DtoUtil.returnSuccess("新增成功!!");
        }

        return DtoUtil.returnSuccess("新增失败!!");
    }
}
