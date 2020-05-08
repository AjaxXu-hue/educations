package org.demo.system.service;

import mapper.system.SysUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pojo.system.SysUser;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {

    @Resource
    SysUserMapper userMapper;

    //查询用户
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询用户信息
        SysUser userInfo = userMapper.findSysUserByName(userName);
        if(null == userInfo){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //查询用户的角色信息
        userInfo.setRoles(userMapper.findSysUserById(userInfo.getId()));
        return userInfo;
    }
}
