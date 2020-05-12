package org.demo.system.service.user;

import org.apache.ibatis.annotations.Param;
import pojo.user.UserExt;

import java.util.List;

public interface UserExtService {

    /**
     * 通过ID查询单条数据
     */
    UserExt findById(Long id);

    /**
     * 查询指定行数据
     */
    List<UserExt> findAllByLimit(int offset, int limit);


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

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);
}
