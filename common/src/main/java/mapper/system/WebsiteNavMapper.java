package mapper.system;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.system.WebsiteBar;
import pojo.system.WebsiteNav;

import java.util.List;

/**
 * 站点导航(WebsiteNav)表数据库访问层
 */
//@Mapper
public interface WebsiteNavMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WebsiteNav findById(Long id);

    /**
     * 通过条件查询(名称，状态)
     */
    List<WebsiteNav> findAll(@Param("navName") String navName , @Param("statusId") String statusId ,
                             @Param("parentId") String parentId);

    /**
     * 新增数据
     *
     * @param websiteNav 实例对象
     * @return 影响行数
     */
    int insertNavInfo(WebsiteNav websiteNav);

    /**
     * 修改数据
     *
     * @param websiteNav 实例对象
     * @return 影响行数
     */
    int updateNavInfo(WebsiteNav websiteNav);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 由父级ID删除数据
     */
    int deleteByParent(Long parentId);

}