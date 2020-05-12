package org.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.system.service.course.CourseService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.course.Course;
import pojo.course.CourseCategory;
import pojo.trans.UpdateCourseListPut;
import pojo.trans.UpdateCourseType;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//课程信息
@Api(value = "CourseController" , tags = "课程信息接口")
@RestController
public class CourseController {

    @Resource
    CourseService courseService;

    //根据条件查询信息(课程信息)
    @ApiOperation(value = "查询课程信息列表" , notes = "1.查询全部课程信息</br>2.根据条件查询课程信息[课程名称、状态、是否收费、上下架]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "coName" , value = "分类名称"),
            @ApiImplicitParam(paramType = "query" , name = "status" , value = "状态"),
            @ApiImplicitParam(paramType = "query" , name = "free" , value = "是否免费[7=免费 8=收费]"),
            @ApiImplicitParam(paramType = "query" , name = "putaway" , value = "上下架[5=上架 6=下架]")
    })
    @GetMapping("/course/courseInfo/coList/findAll")
    public Dto courseFindAll(@RequestParam(value = "coName" , required = false) String coName ,
                             @RequestParam(value = "status" , required = false) String status,
                             @RequestParam(value = "free" , required = false) String free,
                             @RequestParam(value = "putaway" , required = false) String putaway){

        //添加数据
        Course course = new Course();
        course.setCourseName(coName);
        //状态判断
        if(status != null && !status.equals("")) {
            course.setStatusId(Integer.parseInt(status));
        }
        //是否免费[7=免费 8=收费]
        if(free != null && !free.equals("")) {
            course.setIsFree(Integer.parseInt(free));
        }
        //上下架[5=上架 6=下架]
        if(putaway != null && !putaway.equals("")) {
            course.setIsPutaway(Integer.parseInt(putaway));
        }

        //查询
        List<Course> findByAll = courseService.findAll(course);

        if(findByAll == null){
            return DtoUtil.returnSuccess("未查询到课程信息!!");
        }
        return DtoUtil.returnDataSuccess(findByAll);
    }

    //上下架
    @ApiOperation(value = "课程上下架" , notes = "课程上下架")
    @PostMapping("/course/courseInfo/coList/isPutaway")
    public Dto updateInfo(@RequestBody UpdateCourseListPut updateCourseListPut){
        //添加数据
        Course course = new Course();
        course.setId(updateCourseListPut.getId());
        course.setIsPutaway(updateCourseListPut.getIsPutaway());
        course.setGmtModified(new Date());

        //修改
        int count = courseService.updateCourseInfo(course);
        if(count < 0){
            return DtoUtil.returnSuccess("上架修改失败!!");
        }

        return DtoUtil.returnSuccess("上架修改成功");
    }
}
