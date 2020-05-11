package org.demo.system.service;

import pojo.system.WebsiteNavArticle;

public interface WebsiteNavArticleService {

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
