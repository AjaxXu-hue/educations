package mapper.user;

import org.apache.ibatis.annotations.Param;
import pojo.user.LecturerExt;

import java.util.List;

/**
 * 讲师账户信息表(LecturerExt)表数据库访问层
 */
public interface LecturerExtMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LecturerExt findById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LecturerExt> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lecturerExt 实例对象
     * @return 对象列表
     */
    List<LecturerExt> findAll(LecturerExt lecturerExt);

    /**
     * 新增数据
     *
     * @param lecturerExt 实例对象
     * @return 影响行数
     */
    int insertLectureBank(LecturerExt lecturerExt);

    /**
     * 修改数据
     *
     * @param lecturerExt 实例对象
     * @return 影响行数
     */
    int updateLectureBank(LecturerExt lecturerExt);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}