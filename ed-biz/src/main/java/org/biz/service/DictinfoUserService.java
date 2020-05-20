package org.biz.service;

import org.springframework.stereotype.Service;
import pojo.user.Dictinfo;

import java.util.List;

public interface DictinfoUserService {

    //根据Id查询信息
    Dictinfo findIdByInfo(Integer id);
}
