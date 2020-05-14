package org.demo.system.service.adv;

import pojo.course.Adv;

import java.util.List;

//广告信息
public interface AdvService {

    /**
     * 通过ID查询单条数据
     */
    Adv findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Adv> findAll(Adv adv);

    /**
     * 新增数据
     */
    int insertAdvInfo(Adv adv);

    /**
     * 修改数据
     */
    int updateAdvInfo(Adv adv);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);
}
