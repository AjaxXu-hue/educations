package org.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.system.service.course.CourseAuditService;
import org.demo.system.service.course.CourseIntroduceAuditService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.com.UpdateCourseAudit;
import pojo.course.CourseAudit;
import pojo.course.CourseIntroduceAudit;
import pojo.system.WebsiteLink;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//课程信息-审核
@RestController
@Api(value = "CourseAuditController" , tags = "课程信息-审核接口")
public class CourseAuditController {

    @Resource
    CourseAuditService courseAuditService;//课程信息-审核

    @Resource
    CourseIntroduceAuditService courseIntroduceAuditService;//课程信息简介-审核

    //根据条件查询 课程-审核 信息列表
    @ApiOperation(value = "查询课程-审核信息列表" , notes = "1.查询全部课程-审核信息</br>2.根据条件查询课程-审核信息[课程名称、状态、是否免费、上下架、审核状态]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "coName" , value = "分类名称"),
            @ApiImplicitParam(paramType = "query" , name = "status" , value = "状态"),
            @ApiImplicitParam(paramType = "query" , name = "free" , value = "是否免费[7=免费 8=收费]"),
            @ApiImplicitParam(paramType = "query" , name = "putaway" , value = "上下架[5=上架 6=下架]"),
            @ApiImplicitParam(paramType = "query" , name = "audit" , value = "审核[9=上待审核 10=通过 11=失败]")
    })
    @GetMapping("/course/courseInfo/coAudit/findAll")
    public Dto courseFindAll(@RequestParam(value = "coName" , required = false) String coName ,
                             @RequestParam(value = "status" , required = false) String status,
                             @RequestParam(value = "free" , required = false) String free,
                             @RequestParam(value = "putaway" , required = false) String putaway,
                             @RequestParam(value = "audit" , required = false) String audit){

        //添加数据
        CourseAudit courseAudit = new CourseAudit();
        courseAudit.setCourseName(coName);
        //状态判断
        if(status != null && !status.equals("")) {
            courseAudit.setStatusId(Integer.parseInt(status));
        }
        //是否免费[7=免费 8=收费]
        if(free != null && !free.equals("")) {
            courseAudit.setIsFree(Integer.parseInt(free));
        }
        //上下架[5=上架 6=下架]
        if(putaway != null && !putaway.equals("")) {
            courseAudit.setIsPutaway(Integer.parseInt(putaway));
        }
        //审核状态
        if(audit != null && !audit.equals("")) {
            courseAudit.setAuditStatus(Integer.parseInt(audit));
        }

        //查询
        List<CourseAudit> findByAll = courseAuditService.findAll(courseAudit);

        if(findByAll == null){
            return DtoUtil.returnSuccess("未查询到课程-审核信息!!");
        }
        return DtoUtil.returnDataSuccess(findByAll);
    }

    //课程-审核禁用(启用) [软删除]
    @ApiOperation(value = "课程-审核禁用(启用) [软删除]" , notes = "1.课程-审核禁用(启用)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "id" , value = "编号"),
            @ApiImplicitParam(paramType = "query" , name = "status" , value = "状态")
    })
    @GetMapping("/course/courseInfo/coAudit/status")
    public Dto updateCoAuditById(@RequestParam(value = "id" , required = true) String id ,
                                 @RequestParam(value = "status" , required = true) String status){
        //设置禁用操作
        CourseAudit courseAudit = new CourseAudit();
        courseAudit.setId(Long.parseLong(id));
        courseAudit.setStatusId(Integer.parseInt(status));

        //修改操作
        int count = courseAuditService.updateCoAuditInfo(courseAudit);
        if(count < 0){
            DtoUtil.returnFail("修改连接失败" , "10020");
        }

        return DtoUtil.returnSuccess("修改连接成功");
    }

    //根据ID查询信息
    @ApiOperation(value = "根据ID查询信息" , notes = "根据ID查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "id" , value = "编号")
    })
    @GetMapping("/course/courseInfo/coAudit/update/findById")
    public Dto updateCoAuditById(@RequestParam(value = "id" , required = true) String id){

        //查询操作
        CourseAudit courseAudit = courseAuditService.findById(Long.parseLong(id));

        //根据课程介绍ID查询课程简介信息(待审核的简介信息)

        if(courseAudit == null){
            DtoUtil.returnSuccess("未查询到信息");
        }

        return DtoUtil.returnDataSuccess(courseAudit);
    }

    //修改课程-审核
    @ApiOperation(value = "修改课程-审核信息" , notes = "1.修改课程-审核信息")
    @PostMapping("/course/courseInfo/coAudit/update/info")
    public Dto updateCoAuditInfo(@RequestBody UpdateCourseAudit updateCourseAudit){
        int count = 0;

        //修改待审核的课程简介
        //根据ID查询待审核的课程信息
        CourseAudit courseAuditInfo = courseAuditService.findById(updateCourseAudit.getId());
        //根据课程简介信息ID修改课程简介信息
        CourseIntroduceAudit courseIntroduceAudit = new CourseIntroduceAudit();
        courseIntroduceAudit.setIntroduce(updateCourseAudit.getIntroduce());
        courseIntroduceAudit.setId(courseAuditInfo.getIntroduceId());
        courseIntroduceAudit.setGmtModified(new Date());

        count = courseIntroduceAuditService.updateCoIntroduceInfo(courseIntroduceAudit);

        //修改课程-审核内容
        CourseAudit courseAudit = new CourseAudit();
        courseAudit.setId(updateCourseAudit.getId());
        courseAudit.setCourseName(updateCourseAudit.getCourseName());
        courseAudit.setIsFree(updateCourseAudit.getIsFree());
        courseAudit.setSort(updateCourseAudit.getSort());

        count = courseAuditService.updateCoAuditInfo(courseAudit);

        if(count < 0){
            return DtoUtil.returnFail("修改失败" , "20010");
        }

        //修改课程简介
        return DtoUtil.returnSuccess("修改成功!!");

//        {
//            "courseName": "测试下单课程01",
//                "courseOriginal": 100,
//                "id": 1085453180200448002,
//                "introduce": "测试下单数据",
//                "isFree": 7,
//                "sort": 2
//        }
    }
}
