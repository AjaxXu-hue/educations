package mapper.system;

import org.apache.ibatis.annotations.Mapper;
import pojo.system.Menu;

import java.util.List;

//@Mapper
public interface MenuMapper {

    //查询所有路径信息
    List<Menu> getAllMenu();
}
