package org.demo.system.service;

import mapper.system.WebsiteNavMapper;
import org.springframework.stereotype.Service;
import pojo.system.WebsiteNav;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WebsiteNavServiceImpl implements WebsiteNavService{

    @Resource
    WebsiteNavMapper websiteNavMapper;

    //通过ID查询单条数据
    @Override
    public WebsiteNav findById(Long id) {
        return websiteNavMapper.findById(id);
    }

    //通过条件查询(名称，状态)
    @Override
    public List<WebsiteNav> findAll(String navName, String statusId , String parentId) {
        return websiteNavMapper.findAll(navName, statusId , parentId);
    }

    //新增数据
    @Override
    public int insertNavInfo(WebsiteNav websiteNav) {
        return websiteNavMapper.insertNavInfo(websiteNav);
    }

    //修改数据
    @Override
    public int updateNavInfo(WebsiteNav websiteNav) {
        return websiteNavMapper.updateNavInfo(websiteNav);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return websiteNavMapper.deleteById(id);
    }

    //由父级ID删除数据
    @Override
    public int deleteByParent(Long parentId) {
        return websiteNavMapper.deleteByParent(parentId);
    }
}
