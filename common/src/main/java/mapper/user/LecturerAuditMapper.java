package mapper.user;

import org.apache.ibatis.annotations.Param;
import pojo.user.LecturerAudit;

import java.util.List;

/**
 * 讲师信息-审核(LecturerAudit)表数据库访问层
 */
public interface LecturerAuditMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LecturerAudit findById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LecturerAudit> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lecturerAudit 实例对象
     * @return 对象列表
     */
    List<LecturerAudit> findAll(LecturerAudit lecturerAudit);

    /**
     * 新增数据
     *
     * @param lecturerAudit 实例对象
     * @return 影响行数
     */
    int insertAuditInfo(LecturerAudit lecturerAudit);

    /**
     * 修改数据
     *
     * @param lecturerAudit 实例对象
     * @return 影响行数
     */
    int updateAuditInfo(LecturerAudit lecturerAudit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}