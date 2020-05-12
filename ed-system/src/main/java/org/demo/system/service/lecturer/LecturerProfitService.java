package org.demo.system.service.lecturer;

import pojo.user.LecturerProfit;

import java.util.List;

//讲师提现日志表
public interface LecturerProfitService {

    /**
     * 通过ID查询单条数据
     */
    LecturerProfit findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<LecturerProfit> findAll(LecturerProfit lecturerProfit);

    /**
     * 新增数据
     */
    int insertLeProfit(LecturerProfit lecturerProfit);

    /**
     * 修改数据
     */
    int updateLeProfit(LecturerProfit lecturerProfit);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);
}
