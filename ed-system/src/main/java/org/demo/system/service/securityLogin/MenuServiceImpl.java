package org.demo.system.service.securityLogin;

import mapper.system.MenuMapper;
import org.springframework.stereotype.Service;
import pojo.system.Menu;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Resource
    MenuMapper menuMapper;

    //获取所有菜单资源
    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }




}
