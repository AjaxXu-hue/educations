package org.demo.system.service.lecturer;

import mapper.user.LecturerExtMapper;
import org.springframework.stereotype.Service;
import pojo.user.LecturerExt;

import javax.annotation.Resource;
import java.util.List;

//讲师中心-扩展表
@Service
public class LecturerExtServiceImpl implements LecturerExtService{

    @Resource
    LecturerExtMapper lecturerExtMapper;

    @Override
    public LecturerExt findById(Long id) {
        return lecturerExtMapper.findById(id);
    }

    @Override
    public List<LecturerExt> findAllByLimit(int offset, int limit) {
        return lecturerExtMapper.findAllByLimit(offset, limit);
    }

    @Override
    public List<LecturerExt> findAll(LecturerExt lecturerExt) {
        return lecturerExtMapper.findAll(lecturerExt);
    }

    @Override
    public int insertLectureBank(LecturerExt lecturerExt) {
        return lecturerExtMapper.insertLectureBank(lecturerExt);
    }

    @Override
    public int updateLectureBank(LecturerExt lecturerExt) {
        return lecturerExtMapper.updateLectureBank(lecturerExt);
    }

    @Override
    public int deleteById(Long id) {
        return lecturerExtMapper.deleteById(id);
    }
}
