package org.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.demo.system.service.course.CourseCategoryService;
import org.springframework.web.bind.annotation.*;
import pojo.Dto;
import pojo.course.CourseCategory;
import pojo.trans.InsertCourseType;
import pojo.trans.UpdateCourseType;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//课程分类
@RestController
@Api(value = "LecturerProfitController" , tags = "课程分类接口")
public class CourseCategoryController {

    @Resource
    CourseCategoryService courseCategoryService;

    //根据条件查询 分类 信息列表
    @ApiOperation(value = "查询分类信息列表" , notes = "1.查询全部分类信息[根据父类查询]</br>2.根据条件查询分类信息[分类名称、状态]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "coName" , value = "分类名称"),
            @ApiImplicitParam(paramType = "query" , name = "status" , value = "状态"),
            @ApiImplicitParam(paramType = "query" , name = "parentId" , value = "父类Id")
    })
    @GetMapping("/course/type/list/findAll")
    public Dto courseFindAll(@RequestParam(value = "coName" , required = false) String coName ,
                             @RequestParam(value = "status" , required = false) String status,
                             @RequestParam(value = "parentId" , required = false) String parentId){

        //添加数据
        CourseCategory courseCategory = new CourseCategory();
        //状态判断
        courseCategory.setCategoryName(coName);
        if(status != null && !status.equals("")) {
            courseCategory.setStatusId(Integer.parseInt(status));
        }

        //查询
        List<CourseCategory> findByParentId = null;
        if(coName != null && !coName.equals("") || status != null && !status.equals("")){
            findByParentId = courseCategoryService.findAll(courseCategory);
        } else {
            findByParentId = courseCategoryService.findByParentId(Long.parseLong(parentId));
        }

        if(findByParentId == null){
            return DtoUtil.returnSuccess("未查询到课程分类信息!!");
        }
        return DtoUtil.returnDataSuccess(findByParentId);
    }

    //根据Id查询 分类 信息列表
    @ApiOperation(value = "查询分类信息列表" , notes = "1.根据ID查询信息")
    @ApiImplicitParam(paramType = "query" , name = "coId" , value = "编号")
    @GetMapping("/course/type/list/update/findById")
    public Dto courseFindById(@RequestParam(value = "coId" , required = true) String coId ){

        //查询
        CourseCategory findById = courseCategoryService.findById(Long.parseLong(coId));
        if(findById == null){
            return DtoUtil.returnSuccess("未查询到课程分类信息!!");
        }

        return DtoUtil.returnDataSuccess(findById);
    }

    //修改数据
    @ApiOperation(value = "修改分类信息" , notes = "根据ID修改分类信息")
    @PostMapping("/course/type/list/update/Info")
    public Dto updateInfo(@RequestBody UpdateCourseType updateCourse){
        //添加数据
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setId(updateCourse.getId());
        courseCategory.setCategoryName(updateCourse.getCategoryName());
        courseCategory.setSort(updateCourse.getSort());
        courseCategory.setRemark(updateCourse.getRemark());
        courseCategory.setGmtModified(new Date());

        //修改
        int count = courseCategoryService.updateCourseInfo(courseCategory);
        if(count < 0){
            return DtoUtil.returnSuccess("修改失败!!");
        }

        return DtoUtil.returnSuccess("修改成功");
    }

    //新增(1.根据父类进行新增  2.新增一级列表)
    @ApiOperation(value = "新增分类信息" , notes = "1.根据父类进行新增</br>2.新增一级列表")
    @PostMapping("/course/type/list/insertInfo")
    public Dto insertInfo(@RequestBody InsertCourseType insertCourse){
        //添加数据
        CourseCategory courseCategory = new CourseCategory();
        if(insertCourse != null && !insertCourse.equals("")){
            courseCategory.setParentId(insertCourse.getParentId());
            courseCategory.setFloor(1);
        }else {
            courseCategory.setParentId(Long.parseLong("0"));
            courseCategory.setFloor(2);
        }
        courseCategory.setStatusId(1);
        courseCategory.setCategoryName(insertCourse.getCategoryName());
        courseCategory.setSort(insertCourse.getSort());
        courseCategory.setCategoryType(3);
        courseCategory.setRemark(insertCourse.getRemark());
        courseCategory.setGmtCreate(new Date());
        courseCategory.setGmtModified(new Date());

        //修改
        int count = courseCategoryService.insertCourseInfo(courseCategory);
        if(count < 0){
            return DtoUtil.returnSuccess("新增失败!!");
        }

        return DtoUtil.returnSuccess("新增成功");
    }
}
