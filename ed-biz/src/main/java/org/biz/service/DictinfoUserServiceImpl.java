package org.biz.service;

import mapper.user.DictinfoUserMapper;
import org.springframework.stereotype.Service;
import pojo.user.Dictinfo;

import javax.annotation.Resource;

@Service
public class DictinfoUserServiceImpl implements DictinfoUserService{

    @Resource
    DictinfoUserMapper dictinfoMapper;


    @Override
    public Dictinfo findIdByInfo(Integer id) {
        return dictinfoMapper.findIdByInfo(id);
    }
}
