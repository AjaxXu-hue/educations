package org.demo.system.service.course;

import pojo.course.CourseIntroduceAudit;

import java.util.List;

/**
 * 课程介绍信息-审核(CourseIntroduceAudit)
 */
public interface CourseIntroduceAuditService {

    /**
     * 通过ID查询单条数据
     */
    CourseIntroduceAudit findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<CourseIntroduceAudit> findAll(CourseIntroduceAudit courseIntroduceAudit);

    /**
     * 新增数据
     */
    int insertCoIntroduceInfo(CourseIntroduceAudit courseIntroduceAudit);

    /**
     * 修改数据
     */
    int updateCoIntroduceInfo(CourseIntroduceAudit courseIntroduceAudit);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}