package mapper.system;

import org.apache.ibatis.annotations.Param;
import pojo.system.WebsiteNavArticle;

import java.util.List;

/**
 * 站点导航文章(WebsiteNavArticle)表数据库访问层
 */
public interface WebsiteNavArticleMapper {

    /**
     * 通过导航ID查询单条数据
     */
    WebsiteNavArticle findByNavId(Long navId);

    /**
     * 新增数据
     */
    int insertArticle(WebsiteNavArticle websiteNavArticle);

    /**
     * 修改数据
     */
    int updateArticle(WebsiteNavArticle websiteNavArticle);

    /**
     * 通过导航ID删除数据
     */
    int deleteById(Long navId);

}