package mapper.user;

import org.apache.ibatis.annotations.Param;
import pojo.user.UserExt;

import java.util.List;

/**
 * 用户教育信息(UserExt)表数据库访问层
 */
public interface UserExtMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserExt findById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserExt> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userExt 实例对象
     * @return 对象列表
     */
    List<UserExt> findAll(UserExt userExt);

    /**
     * 新增数据
     *
     * @param userExt 实例对象
     * @return 影响行数
     */
    int insertUserExtInfo(UserExt userExt);

    /**
     * 修改数据
     *
     * @param userExt 实例对象
     * @return 影响行数
     */
    int updateUserExtInfo(UserExt userExt);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}