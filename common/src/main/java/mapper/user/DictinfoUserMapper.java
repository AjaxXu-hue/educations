package mapper.user;


import pojo.user.Dictinfo;

import java.util.List;

//@Mapper
public interface DictinfoUserMapper {

    //根据Id查询信息
    Dictinfo findIdByInfo(Integer id);
}
