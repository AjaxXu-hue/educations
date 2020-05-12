package org.demo.system.service.lecturer;

import mapper.user.LecturerProfitMapper;
import org.springframework.stereotype.Service;
import pojo.user.LecturerProfit;

import javax.annotation.Resource;
import java.util.List;

//讲师提现日志表
@Service
public class LecturerProfitServiceImpl implements LecturerProfitService{

    @Resource
    LecturerProfitMapper lecturerProfitMapper;

    //通过ID查询单条数据
    @Override
    public LecturerProfit findById(Long id) {
        return lecturerProfitMapper.findById(id);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<LecturerProfit> findAll(LecturerProfit lecturerProfit) {
        return lecturerProfitMapper.findAll(lecturerProfit);
    }

    //新增数据
    @Override
    public int insertLeProfit(LecturerProfit lecturerProfit) {
        return lecturerProfitMapper.insertLeProfit(lecturerProfit);
    }

    //修改数据
    @Override
    public int updateLeProfit(LecturerProfit lecturerProfit) {
        return lecturerProfitMapper.updateLeProfit(lecturerProfit);
    }

    //通过主键删除数据
    @Override
    public int deleteById(Long id) {
        return lecturerProfitMapper.deleteById(id);
    }
}
