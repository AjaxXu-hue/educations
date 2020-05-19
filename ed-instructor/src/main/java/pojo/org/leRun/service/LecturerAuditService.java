package pojo.org.leRun.service;

import pojo.user.LecturerAudit;

import java.util.List;

/**
 * 讲师信息-审核(LecturerAudit)
 */
public interface LecturerAuditService {

    //通过ID查询单条数据
    LecturerAudit findById(Long id);

    // 查询指定行数据
    List<LecturerAudit> findAllByLimit(int offset, int limit);

    //通过实体作为筛选条件查询=
    List<LecturerAudit> findAll(LecturerAudit lecturerAudit);

    //新增数据
    int insertAuditInfo(LecturerAudit lecturerAudit);

    //修改数据
    int updateAuditInfo(LecturerAudit lecturerAudit);

    //通过主键删除数据
    int deleteById(Long id);
}
