package mapper.course;

import org.apache.ibatis.annotations.Param;
import pojo.course.Course;

import java.util.List;

/**
 * 课程信息(Course)表数据库访问层
 */
public interface CourseMapper {

    /**
     * 通过ID查询单条数据
     */
    Course findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Course> findAll(Course course);

    /**
     * 新增数据
     */
    int insertCourseInfo(Course course);

    /**
     * 修改数据
     */
    int updateCourseInfo(Course course);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}