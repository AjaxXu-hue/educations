package pojo.org.leRun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.com.InsertCourseAudit;
import pojo.course.Course;
import pojo.course.CourseAudit;
import pojo.course.CourseIntroduceAudit;
import pojo.org.leRun.service.course.CourseAuditService;
import pojo.org.leRun.service.course.CourseIntroduceAuditService;
import pojo.org.leRun.service.course.CourseService;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "LeCourseController" , tags = "讲师课程管理接口")
public class LeCourseController {

    @Resource
    CourseService courseService;//课程信息

    @Resource
    CourseAuditService courseAuditService;//课程信息-审核

    @Resource
    CourseIntroduceAuditService courseIntroduceAuditService;////课程介绍信息-审核

    //查看讲师课程信息
    @ApiOperation(value = "查询相关教师的课程信息", notes = "1.审核通过的课程信息</br>2.审核未通过的课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "leUserNo", value = "讲师编号" , required = true),
            @ApiImplicitParam(paramType = "query", name = "coStatus", value = "审核编号 9=待审核  11=审核失败")})
    @GetMapping("/course/LeInfo")
    public Dto courseInfo(@RequestParam(value = "leUserNo") String leUserNo ,
                          @RequestParam(value = "coStatus" , required = false) String coStatus){

        if(coStatus != null && !coStatus.equals("")){
            CourseAudit courseAudit = new CourseAudit();
            courseAudit.setLecturerUserNo(Long.parseLong(leUserNo));
            courseAudit.setAuditStatus(Integer.parseInt(coStatus));
            List<CourseAudit> findCourseAudit = courseAuditService.findAll(courseAudit);
            return DtoUtil.returnDataSuccess(findCourseAudit);
        }else {
            //查询该教师的课程信息
            Course course = new Course();
            course.setLecturerUserNo(Long.parseLong(leUserNo));
            List<Course> findByLeUserNo = courseService.findAll(course);
            return DtoUtil.returnDataSuccess(findByLeUserNo);
        }
    }

    //新增讲师课程信息
    @ApiOperation(value = "新增讲师课程信息", notes = "1.新增讲师课程信息(课程介绍信息)")
    @PostMapping("/course/insertLeCou")
    public Dto courseInfo(@RequestBody InsertCourseAudit insertCourseAudit){
        //添加课程简介信息
        CourseIntroduceAudit courseIntroduceAudit = new CourseIntroduceAudit();
        courseIntroduceAudit.setGmtModified(new Date());
        courseIntroduceAudit.setGmtCreate(new Date());
        courseIntroduceAudit.setIntroduce(insertCourseAudit.getIntroduce());
        //获取年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        //获取时间戳
        String time=dateFormat.format(new Date());
        //生成4位随机数
        int ran = (int)((Math.random()*9+1)*1000);
        String id = time+ran;
        courseIntroduceAudit.setId(Long.parseLong(id));

        //简介信息
        int count = courseIntroduceAuditService.insertCoIntroduceInfo(courseIntroduceAudit);

        //审核课程信息
        CourseAudit courseAudit = new CourseAudit();
        courseAudit.setLecturerUserNo(insertCourseAudit.getLecturerUserNo());
        courseAudit.setCourseName(insertCourseAudit.getCourseName());
        courseAudit.setCategoryId1(insertCourseAudit.getCategoryId1());
        courseAudit.setCategoryId2(insertCourseAudit.getCategoryId2());
        courseAudit.setCategoryId3(insertCourseAudit.getCategoryId3());
        courseAudit.setCourseLogo(insertCourseAudit.getCourseLogo());
        courseAudit.setCourseOriginal(insertCourseAudit.getCourseOriginal());
        courseAudit.setIsFree(insertCourseAudit.getIsFree());
        courseAudit.setGmtModified(new Date());
        courseAudit.setGmtCreate(new Date());
        courseAudit.setIntroduceId(Long.parseLong(id));

        count = courseAuditService.insertCoAuditInfo(courseAudit);

        if(count < 0){
            return DtoUtil.returnSuccess("新增失败");
        }

        return DtoUtil.returnSuccess("新增成功");
    }

}
