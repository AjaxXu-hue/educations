package com.system.service;

import pojo.system.WebsiteBar;

import java.util.List;

public interface WebsiteBarService {

    //通过ID查询单条数据
    WebsiteBar findById(Long id);

    //查询指定行数据
    List<WebsiteBar> findAllByLimit(int offset, int limit);


    //通过实体作为筛选条件查询
//    List<WebsiteBar> findAll(WebsiteBar websiteBar);
    List<WebsiteBar> findAll(String navTitle, String statusId);

    // 新增数据
    int insertBarInfo(WebsiteBar websiteBar);

    //修改数据
    int updateBarInfo(WebsiteBar websiteBar);

    //通过主键删除数据
    int deleteById(Long id);
}
