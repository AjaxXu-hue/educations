package pojo.org.leRun.service.course;

import mapper.course.CourseMapper;
import org.springframework.stereotype.Service;
import pojo.course.Course;

import javax.annotation.Resource;
import java.util.List;

//课程信息
@Service
public class CourseServiceImpl implements CourseService{

    @Resource
    CourseMapper courseMapper;

    //通过ID查询单条数据
    @Override
    public Course findById(Long id) {
        return courseMapper.findById(id);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<Course> findAll(Course course) {
        return courseMapper.findAll(course);
    }

    //新增数据
    @Override
    public int insertCourseInfo(Course course) {
        return courseMapper.insertCourseInfo(course);
    }

    //修改数据
    @Override
    public int updateCourseInfo(Course course) {
        return courseMapper.updateCourseInfo(course);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return courseMapper.deleteById(id);
    }
}
