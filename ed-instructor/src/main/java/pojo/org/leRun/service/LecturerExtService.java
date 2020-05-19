package pojo.org.leRun.service;

import pojo.user.LecturerExt;

import java.util.List;

//讲师中心-扩展表
public interface LecturerExtService {

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
    List<LecturerExt> findAllByLimit(int offset, int limit);


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
     * 通过讲师用户编码修改数据
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
