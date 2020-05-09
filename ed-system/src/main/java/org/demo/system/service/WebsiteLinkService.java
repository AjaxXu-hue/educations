package org.demo.system.service;

import pojo.system.WebsiteLink;

import java.util.List;

public interface WebsiteLinkService {

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
    List<WebsiteLink> findAllByLimit(int offset, int limit);


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
