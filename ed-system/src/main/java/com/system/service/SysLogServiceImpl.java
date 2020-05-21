package com.system.service;

import mapper.system.SysLogMapper;
import org.springframework.stereotype.Service;
import pojo.system.SysLog;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台操作日志表
 */
@Service
public class SysLogServiceImpl implements SysLogService{

    @Resource
    SysLogMapper sysLogMapper;


    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.findById(id);
    }

    @Override
    public List<SysLog> findAll(SysLog sysLog) {
        return sysLogMapper.findAll(sysLog);
    }

    @Override
    public int insertLogInfo(SysLog sysLog) {
        return sysLogMapper.insertLogInfo(sysLog);
    }

    @Override
    public int updateLongInfo(SysLog sysLog) {
        return sysLogMapper.updateLongInfo(sysLog);
    }

    @Override
    public int deleteById(Long id) {
        return sysLogMapper.deleteById(id);
    }
}