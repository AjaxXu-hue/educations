package com.system.service.course;

import pojo.course.CourseAudit;

import java.util.List;

public interface CourseAuditService {

    /**
     * 通过ID查询单条数据
     */
    CourseAudit findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<CourseAudit> findAll(CourseAudit courseAudit);

    /**
     * 新增数据
     */
    int insertCoAuditInfo(CourseAudit courseAudit);

    /**
     * 修改数据
     */
    int updateCoAuditInfo(CourseAudit courseAudit);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);
}
