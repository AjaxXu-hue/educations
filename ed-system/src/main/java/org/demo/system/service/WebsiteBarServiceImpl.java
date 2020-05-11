package org.demo.system.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import mapper.system.WebsiteBarMapper;
import org.springframework.stereotype.Service;
import pojo.system.WebsiteBar;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WebsiteBarServiceImpl implements WebsiteBarService{

    @Resource
    WebsiteBarMapper websiteBarMapper;

    //通过ID查询单条数据
    @Override
    public WebsiteBar findById(Long id) {
        return websiteBarMapper.findById(id);
    }

    //查询指定行数据
    @Override
    public List<WebsiteBar> findAllByLimit(int offset, int limit) {
        return websiteBarMapper.findAllByLimit(offset, limit);
    }

    //通过实体作为筛选条件查询
//    @Override
//    public List<WebsiteBar> findAll(WebsiteBar websiteBar) {
//        return websiteBarMapper.findAll(websiteBar);
//    }
    @Override
    public List<WebsiteBar> findAll(String navTitle, String statusId) {
        return websiteBarMapper.findAll(navTitle, statusId);
    }

    //新增数据
    @Override
    public int insertBarInfo(WebsiteBar websiteBar) {
        return websiteBarMapper.insertBarInfo(websiteBar);
    }

    //修改数据
    @Override
    public int updateBarInfo(WebsiteBar websiteBar) {
        return websiteBarMapper.updateBarInfo(websiteBar);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return websiteBarMapper.deleteById(id);
    }
}
