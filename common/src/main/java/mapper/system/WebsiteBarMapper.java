package mapper.system;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.system.WebsiteBar;

import java.util.List;

/**
 * 头部导航(WebsiteBar)表数据库访问层
 */
//@Mapper
public interface WebsiteBarMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WebsiteBar findById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WebsiteBar> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
//     * @param websiteBar 实例对象
     * @return 对象列表
     */
    List<WebsiteBar> findAll(@Param("navTitle") String navTitle, @Param("statusId") String statusId);
//    List<WebsiteBar> findAll(WebsiteBar websiteBar);

    /**
     * 新增数据
     *
     * @param websiteBar 实例对象
     * @return 影响行数
     */
    int insertBarInfo(WebsiteBar websiteBar);

    /**
     * 修改数据
     *
     * @param websiteBar 实例对象
     * @return 影响行数
     */
    int updateBarInfo(WebsiteBar websiteBar);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}