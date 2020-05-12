package org.demo.system.service.course;

import pojo.course.CourseCategory;

import java.util.List;

//课程分类
public interface CourseCategoryService {

    /**
     * 通过ID查询单条数据
     */
    CourseCategory findById(Long id);

    /**
     * 通过父类ID查询数据
     */
    List<CourseCategory> findByParentId(Long parentId);

    /**
     * 通过实体作为筛选条件查询
     */
    List<CourseCategory> findAll(CourseCategory courseCategory);

    /**
     * 新增数据
     */
    int insertCourseInfo(CourseCategory courseCategory);

    /**
     * 修改数据
     */
    int updateCourseInfo(CourseCategory courseCategory);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);
}
