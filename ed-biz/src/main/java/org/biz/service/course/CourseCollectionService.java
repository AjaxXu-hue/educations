package org.biz.service.course;

import org.apache.ibatis.annotations.Param;
import pojo.course.CourseCollection;

import java.util.List;

/**
 * (CourseCollection)课程收藏表
 */
public interface CourseCollectionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseCollection queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseCollection> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param courseCollection 实例对象
     * @return 对象列表
     */
    List<CourseCollection> queryAll(CourseCollection courseCollection);

    /**
     * 新增数据
     *
     * @param courseCollection 实例对象
     * @return 影响行数
     */
    int insert(CourseCollection courseCollection);

    /**
     * 修改数据
     *
     * @param courseCollection 实例对象
     * @return 影响行数
     */
    int update(CourseCollection courseCollection);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}