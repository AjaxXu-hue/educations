package com.system.service;

import mapper.user.PlatformMapper;
import org.springframework.stereotype.Service;
import pojo.user.Platform;

import javax.annotation.Resource;
import java.util.List;

//平台信息
@Service
public class PlatformServiceImpl implements PlatformService{

    @Resource
    PlatformMapper platformMapper;

    //通过ID查询单条数据
    @Override
    public Platform findById(Long id) {
        return platformMapper.findById(id);
    }

    //查询指定行数据
    @Override
    public List<Platform> findAllByLimit(int offset, int limit) {
        return platformMapper.findAllByLimit(offset, limit);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<Platform> findAll(Platform platform) {
        return platformMapper.findAll(platform);
    }

    //新增数据
    @Override
    public int insertPlatInfo(Platform platform) {
        return platformMapper.insertPlatInfo(platform);
    }

    //修改数据
    @Override
    public int updatePlatInfo(Platform platform) {
        return platformMapper.updatePlatInfo(platform);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return platformMapper.deleteById(id);
    }
}
