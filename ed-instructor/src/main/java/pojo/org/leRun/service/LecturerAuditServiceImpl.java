package pojo.org.leRun.service;

import mapper.user.LecturerAuditMapper;
import org.springframework.stereotype.Service;
import pojo.user.LecturerAudit;

import javax.annotation.Resource;
import java.util.List;

/**
 * 讲师信息-审核(LecturerAudit)
 */
@Service
public class LecturerAuditServiceImpl implements LecturerAuditService{

    @Resource
    LecturerAuditMapper lecturerAuditMapper;

    //通过ID查询单条数据
    @Override
    public LecturerAudit findById(Long id) {
        return lecturerAuditMapper.findById(id);
    }

    // 查询指定行数据
    @Override
    public List<LecturerAudit> findAllByLimit(int offset, int limit) {
        return lecturerAuditMapper.findAllByLimit(offset, limit);
    }

    //通过实体作为筛选条件查询=
    @Override
    public List<LecturerAudit> findAll(LecturerAudit lecturerAudit) {
        return lecturerAuditMapper.findAll(lecturerAudit);
    }

    //新增数据
    @Override
    public int insertAuditInfo(LecturerAudit lecturerAudit) {
        return lecturerAuditMapper.insertAuditInfo(lecturerAudit);
    }

    //修改数据
    @Override
    public int updateAuditInfo(LecturerAudit lecturerAudit) {
        return lecturerAuditMapper.updateAuditInfo(lecturerAudit);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return lecturerAuditMapper.deleteById(id);
    }

}
