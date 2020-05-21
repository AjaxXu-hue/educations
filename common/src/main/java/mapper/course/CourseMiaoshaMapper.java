package mapper.course;

import org.apache.ibatis.annotations.Param;
import pojo.course.CourseMiaosha;

import java.util.List;

/**
 * (CourseMiaosha)表数据库访问层
 */
public interface CourseMiaoshaMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseMiaosha findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param courseMiaosha 实例对象
     * @return 对象列表
     */
    List<CourseMiaosha> findAll(CourseMiaosha courseMiaosha);

    /**
     * 新增数据
     *
     * @param courseMiaosha 实例对象
     * @return 影响行数
     */
    int insertMiaoShaInfo(CourseMiaosha courseMiaosha);

    /**
     * 修改数据
     *
     * @param courseMiaosha 实例对象
     * @return 影响行数
     */
    int updateMiaoShaInfo(CourseMiaosha courseMiaosha);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    //修改库存信息
    int updateCourseStock(@Param("id") String id , @Param("stoType") String stoType);

}