package org.demo.system.config;

import org.demo.system.service.MenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import pojo.system.Menu;
import pojo.system.Role;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenu = menuService.getAllMenu();
        for (Menu menu : allMenu){
            if (antPathMatcher.match(menu.getApiUrl() , requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] values = new String[roles.size()];
                for (int i = 0 ; i < values.length ; i++){
                    values[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
