package com.system.service;

import mapper.system.WebsiteNavArticleMapper;
import org.springframework.stereotype.Service;
import pojo.system.WebsiteNavArticle;

import javax.annotation.Resource;

@Service
public class WebsiteNavArticleServiceImpl implements WebsiteNavArticleService{

    @Resource
    WebsiteNavArticleMapper WebsiteNavArticleMapper;

    //通过导航ID查询单条数据
    @Override
    public WebsiteNavArticle findByNavId(Long navId) {
        return WebsiteNavArticleMapper.findByNavId(navId);
    }

    //新增数据
    @Override
    public int insertArticle(WebsiteNavArticle websiteNavArticle) {
        return WebsiteNavArticleMapper.insertArticle(websiteNavArticle);
    }

    //修改数据
    @Override
    public int updateArticle(WebsiteNavArticle websiteNavArticle) {
        return WebsiteNavArticleMapper.updateArticle(websiteNavArticle);
    }

    //通过导航ID删除数据
    @Override
    public int deleteById(Long navId) {
        return WebsiteNavArticleMapper.deleteById(navId);
    }
}
