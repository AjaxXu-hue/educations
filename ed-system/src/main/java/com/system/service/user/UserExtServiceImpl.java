package com.system.service.user;

import mapper.user.UserExtMapper;
import org.springframework.stereotype.Service;
import pojo.user.UserExt;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserExtServiceImpl implements UserExtService{

    @Resource
    UserExtMapper userExtMapper;

    //通过ID查询单条数据
    @Override
    public UserExt findById(Long id) {
        return userExtMapper.findById(id);
    }

    //查询指定行数据
    @Override
    public List<UserExt> findAllByLimit(int offset, int limit) {
        return userExtMapper.findAllByLimit(offset, limit);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<UserExt> findAll(UserExt userExt) {
        return userExtMapper.findAll(userExt);
    }

    //新增数据
    @Override
    public int insertUserExtInfo(UserExt userExt) {
        return userExtMapper.insertUserExtInfo(userExt);
    }

    //修改数据
    @Override
    public int updateUserExtInfo(UserExt userExt) {
        return userExtMapper.updateUserExtInfo(userExt);
    }

    @Override
    public int updateUserExtByUserNo(UserExt userExt) {
        return userExtMapper.updateUserExtByUserNo(userExt);
    }

    //删除数据
    @Override
    public int deleteById(Long id) {
        return userExtMapper.deleteById(id);
    }
}
