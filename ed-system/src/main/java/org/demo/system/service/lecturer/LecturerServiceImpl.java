package org.demo.system.service.lecturer;

import mapper.user.LecturerMapper;
import org.springframework.stereotype.Service;
import pojo.user.Lecturer;

import javax.annotation.Resource;
import java.util.List;

//讲师中心
@Service
public class LecturerServiceImpl implements LecturerService{

    @Resource
    LecturerMapper lecturerMapper;

    //通过ID查询单条数据
    @Override
    public Lecturer findById(Long id) {
        return lecturerMapper.findById(id);
    }

    //查询指定行数据
    @Override
    public List<Lecturer> findAllByLimit(int offset, int limit) {
        return lecturerMapper.findAllByLimit(offset, limit);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<Lecturer> findAll(Lecturer lecturer) {
        return lecturerMapper.findAll(lecturer);
    }

    //新增数据
    @Override
    public int insertLecturerInfo(Lecturer lecturer) {
        return lecturerMapper.insertLecturerInfo(lecturer);
    }

    //修改数据
    @Override
    public int updateLecturerInfo(Lecturer lecturer) {
        return lecturerMapper.updateLecturerInfo(lecturer);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return lecturerMapper.deleteById(id);
    }
}
