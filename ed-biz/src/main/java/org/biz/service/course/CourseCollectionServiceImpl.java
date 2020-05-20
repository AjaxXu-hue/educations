package org.biz.service.course;

import mapper.course.CourseCollectionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import pojo.course.CourseCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CourseCollection)课程收藏表
 */
@Service
public class CourseCollectionServiceImpl implements CourseCollectionService{

    @Resource
    CourseCollectionMapper courseCollectionMapper;

    @Override
    public CourseCollection queryById(Integer id) {
        return courseCollectionMapper.queryById(id);
    }

    @Override
    public List<CourseCollection> queryAllByLimit(int offset, int limit) {
        return courseCollectionMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public List<CourseCollection> queryAll(CourseCollection courseCollection) {
        return courseCollectionMapper.queryAll(courseCollection);
    }

    @Override
    public int insert(CourseCollection courseCollection) {
        return courseCollectionMapper.insert(courseCollection);
    }

    @Override
    public int update(CourseCollection courseCollection) {
        return courseCollectionMapper.update(courseCollection);
    }

    @Override
    public int deleteById(Integer id) {
        return courseCollectionMapper.deleteById(id);
    }
}