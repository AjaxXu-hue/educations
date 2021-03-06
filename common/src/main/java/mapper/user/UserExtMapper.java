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
     */
    UserExt findById(Long id);

    /**
     * 查询指定行数据
     */
    List<UserExt> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     */
    List<UserExt> findAll(UserExt userExt);

    /**
     * 新增数据
     */
    int insertUserExtInfo(UserExt userExt);

    /**
     * 修改数据
     */
    int updateUserExtInfo(UserExt userExt);

    //根据用户编号修改信息
    int updateUserExtByUserNo(UserExt userExt);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}