package org.demo.system.service.course;

import mapper.course.CourseIntroduceAuditMapper;
import mapper.course.CourseMapper;
import org.springframework.stereotype.Service;
import pojo.course.CourseIntroduceAudit;

import javax.annotation.Resource;
import java.util.List;

@Service
//课程介绍信息-审核
public class CourseIntroduceAuditServiceImpl implements CourseIntroduceAuditService{

    @Resource
    CourseIntroduceAuditMapper courseIntroduceAuditMapper;

    //通过ID查询单条数据
    @Override
    public CourseIntroduceAudit findById(Long id) {
        return courseIntroduceAuditMapper.findById(id);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<CourseIntroduceAudit> findAll(CourseIntroduceAudit courseIntroduceAudit) {
        return courseIntroduceAuditMapper.findAll(courseIntroduceAudit);
    }

    //新增数据
    @Override
    public int insertCoIntroduceInfo(CourseIntroduceAudit courseIntroduceAudit) {
        return courseIntroduceAuditMapper.insertCoIntroduceInfo(courseIntroduceAudit);
    }

    //修改数据
    @Override
    public int updateCoIntroduceInfo(CourseIntroduceAudit courseIntroduceAudit) {
        return courseIntroduceAuditMapper.updateCoIntroduceInfo(courseIntroduceAudit);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return courseIntroduceAuditMapper.deleteById(id);
    }
}
