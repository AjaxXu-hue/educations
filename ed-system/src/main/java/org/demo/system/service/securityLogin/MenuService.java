package org.demo.system.service.securityLogin;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.system.Menu;

import java.util.List;

public interface MenuService {

    //获取所有菜单资源
    List<Menu> getAllMenu();
}
