package mapper.user;

import org.apache.ibatis.annotations.Param;
import pojo.user.Lecturer;

import java.util.List;

/**
 * 讲师信息(Lecturer)表数据库访问层
 */
public interface LecturerMapper {

    /**
     * 通过ID查询单条数据
     */
    Lecturer findById(Long id);

    /**
     * 查询指定行数据
     */
    List<Lecturer> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     */
    List<Lecturer> findAll(Lecturer lecturer);

    /**
     * 新增数据
     */
    int insertLecturerInfo(Lecturer lecturer);

    /**
     * 修改数据
     */
    int updateLecturerInfo(Lecturer lecturer);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}