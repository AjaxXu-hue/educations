package pojo.org.leRun.service.course;

import mapper.course.CourseAuditMapper;
import org.springframework.stereotype.Service;
import pojo.course.CourseAudit;

import javax.annotation.Resource;
import java.util.List;

//课程信息-审核
@Service
public class CourseAuditServiceImpl implements CourseAuditService{

    @Resource
    CourseAuditMapper courseAuditMapper;

    @Override
    public CourseAudit findById(Long id) {
        return courseAuditMapper.findById(id);
    }

    @Override
    public List<CourseAudit> findAll(CourseAudit courseAudit) {
        return courseAuditMapper.findAll(courseAudit);
    }

    @Override
    public int insertCoAuditInfo(CourseAudit courseAudit) {
        return courseAuditMapper.insertCoAuditInfo(courseAudit);
    }

    @Override
    public int updateCoAuditInfo(CourseAudit courseAudit) {
        return courseAuditMapper.updateCoAuditInfo(courseAudit);
    }

    @Override
    public int deleteById(Long id) {
        return courseAuditMapper.deleteById(id);
    }
}
