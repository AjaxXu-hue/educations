package com.system.service;

import pojo.system.SysLog;

import java.util.List;

/**
 * 后台操作日志表
 */
public interface SysLogService {

    /**
     * 通过ID查询单条数据
     */
    SysLog findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<SysLog> findAll(SysLog sysLog);

    /**
     * 新增数据
     */
    int insertLogInfo(SysLog sysLog);

    /**
     * 修改数据
     */
    int updateLongInfo(SysLog sysLog);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}