package mapper.user;

import org.apache.ibatis.annotations.Param;
import pojo.user.Platform;

import java.util.List;

/**
 * 平台信息(Platform)表数据库访问层
 */
public interface PlatformMapper {

    /**
     * 通过ID查询单条数据
     */
    Platform findById(Long id);

    /**
     * 查询指定行数据
     */
    List<Platform> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     */
    List<Platform> findAll(Platform platform);

    /**
     * 新增数据
     */
    int insertPlatInfo(Platform platform);

    /**
     * 修改数据
     */
    int updatePlatInfo(Platform platform);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}