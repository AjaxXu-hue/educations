package mapper.system;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.system.WebsiteLink;

import java.util.List;

/**
 * 站点友情链接(WebsiteLink)表数据库访问层
 */
//@Mapper
public interface WebsiteLinkMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WebsiteLink findById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WebsiteLink> findAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param websiteLink 实例对象
     * @return 对象列表
     */
    List<WebsiteLink> findAll(WebsiteLink websiteLink);

    /**
     * 新增数据
     *
     * @param websiteLink 实例对象
     * @return 影响行数
     */
    int insertLinkInfo(WebsiteLink websiteLink);

    /**
     * 修改数据
     *
     * @param websiteLink 实例对象
     * @return 影响行数
     */
    int updateLinkInfo(WebsiteLink websiteLink);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}