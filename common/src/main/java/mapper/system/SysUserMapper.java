package mapper.system;

import org.apache.ibatis.annotations.Mapper;
import pojo.system.Role;
import pojo.system.SysUser;

import java.util.List;

@Mapper
public interface SysUserMapper {

    /*
   根据用户名查询信息
    */
    SysUser findSysUserByName(String userName);

    //根据id查询用户角色
    List<Role> findSysUserById(Integer id);
}
