package mapper.system;

import org.apache.ibatis.annotations.Mapper;
import pojo.system.Dictinfo;

import java.util.List;

//@Mapper
public interface DictinfoMapper {

    //根据Id查询信息
    List<Dictinfo> findIdByInfo(Integer id);
}
