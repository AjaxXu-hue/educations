package org.demo.system.service;

import mapper.system.MenuMapper;
import org.springframework.stereotype.Service;
import pojo.system.Menu;

import javax.annotation.Resource;
import java.util.List;

@Service
//@Transactional
//@CacheConfig(cacheNames = "menus_cache")
public class MenuServiceImpl implements MenuService{

    @Resource
    MenuMapper menuMapper;

    //获取所有菜单资源
    @Override
//    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }
}
