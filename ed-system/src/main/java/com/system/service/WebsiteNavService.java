package com.system.service;

import pojo.system.WebsiteNav;

import java.util.List;

public interface WebsiteNavService {

    //通过ID查询单条数据
    WebsiteNav findById(Long id);

    //通过条件查询(名称，状态)
    List<WebsiteNav> findAll(String navName, String statusId , String parentId);

    //新增数据
    int insertNavInfo(WebsiteNav websiteNav);

    //修改数据
    int updateNavInfo(WebsiteNav websiteNav);

    //通过主键删除数据
    int deleteById(Long id);

    //由父级ID删除数据
    int deleteByParent(Long parentId);
}
