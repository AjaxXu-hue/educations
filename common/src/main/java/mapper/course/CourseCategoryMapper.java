package mapper.course;

import org.apache.ibatis.annotations.Param;
import pojo.course.CourseCategory;

import java.util.List;

/**
 * 课程分类(CourseCategory)表数据库访问层
 */
public interface CourseCategoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseCategory findById(Long id);

    /**
     * 通过父类ID查询数据
     */
    List<CourseCategory> findByParentId(Long parentId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param courseCategory 实例对象
     * @return 对象列表
     */
    List<CourseCategory> findAll(CourseCategory courseCategory);

    /**
     * 新增数据
     *
     * @param courseCategory 实例对象
     * @return 影响行数
     */
    int insertCourseInfo(CourseCategory courseCategory);

    /**
     * 修改数据
     *
     * @param courseCategory 实例对象
     * @return 影响行数
     */
    int updateCourseInfo(CourseCategory courseCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}