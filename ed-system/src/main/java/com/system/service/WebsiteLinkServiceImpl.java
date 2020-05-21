package com.system.service;

import mapper.system.WebsiteLinkMapper;
import org.springframework.stereotype.Service;
import pojo.system.WebsiteLink;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WebsiteLinkServiceImpl implements WebsiteLinkService{

    @Resource
    WebsiteLinkMapper websiteLinkMapper;

    //通过ID查询单条数据
    @Override
    public WebsiteLink findById(Long id) {
        return websiteLinkMapper.findById(id);
    }

    //查询指定行数据  offset 查询起始位置   limit 查询条数
    @Override
    public List<WebsiteLink> findAllByLimit(int offset, int limit) {
        return websiteLinkMapper.findAllByLimit(offset, limit);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<WebsiteLink> findAll(WebsiteLink websiteLink) {
        return websiteLinkMapper.findAll(websiteLink);
    }

    //新增数据
    @Override
    public int insertLinkInfo(WebsiteLink websiteLink) {
        return websiteLinkMapper.insertLinkInfo(websiteLink);
    }

    //修改数据
    @Override
    public int updateLinkInfo(WebsiteLink websiteLink) {
        return websiteLinkMapper.updateLinkInfo(websiteLink);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return websiteLinkMapper.deleteById(id);
    }
}
