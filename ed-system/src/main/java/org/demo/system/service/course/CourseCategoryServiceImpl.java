package org.demo.system.service.course;

import mapper.course.CourseCategoryMapper;
import org.springframework.stereotype.Service;
import pojo.course.CourseCategory;

import javax.annotation.Resource;
import java.util.List;

//课程分类
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService{

    @Resource
    CourseCategoryMapper courseCategoryMapper;

    //通过ID查询单条数据
    @Override
    public CourseCategory findById(Long id) {
        return courseCategoryMapper.findById(id);
    }

    //通过父类ID查询数据
    @Override
    public List<CourseCategory> findByParentId(Long parentId) {
        return courseCategoryMapper.findByParentId(parentId);
    }

    @Override
    public List<CourseCategory> findAll(CourseCategory courseCategory) {
        return courseCategoryMapper.findAll(courseCategory);
    }

    @Override
    public int insertCourseInfo(CourseCategory courseCategory) {
        return courseCategoryMapper.insertCourseInfo(courseCategory);
    }

    @Override
    public int updateCourseInfo(CourseCategory courseCategory) {
        return courseCategoryMapper.updateCourseInfo(courseCategory);
    }

    @Override
    public int deleteById(Long id) {
        return courseCategoryMapper.deleteById(id);
    }
}
