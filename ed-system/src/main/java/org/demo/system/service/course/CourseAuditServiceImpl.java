package org.demo.system.service.course;

import org.springframework.stereotype.Service;
import pojo.course.CourseAudit;

import javax.annotation.Resource;
import java.util.List;

//课程信息-审核
@Service
public class CourseAuditServiceImpl implements CourseAuditService{

    @Resource
    CourseAuditService courseAuditService;

    @Override
    public CourseAudit findById(Long id) {
        return courseAuditService.findById(id);
    }

    @Override
    public List<CourseAudit> findAll(CourseAudit courseAudit) {
        return courseAuditService.findAll(courseAudit);
    }

    @Override
    public int insertCoAuditInfo(CourseAudit courseAudit) {
        return courseAuditService.insertCoAuditInfo(courseAudit);
    }

    @Override
    public int updateCoAuditInfo(CourseAudit courseAudit) {
        return courseAuditService.updateCoAuditInfo(courseAudit);
    }

    @Override
    public int deleteById(Long id) {
        return courseAuditService.deleteById(id);
    }
}
