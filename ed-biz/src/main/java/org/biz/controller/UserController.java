package org.biz.controller;

import mapper.system.MenuMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.system.Menu;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    MenuMapper MenuMapper;

    @GetMapping("/hello")
    public Object hello(){
//        SysUser user = new SysUser();
        List<Menu> user = MenuMapper.getAllMenu();
        return user;
    }
}
