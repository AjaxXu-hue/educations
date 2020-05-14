package org.demo.system.service.adv;

import mapper.course.AdvMapper;
import org.springframework.stereotype.Service;
import pojo.course.Adv;

import javax.annotation.Resource;
import java.util.List;

//广告信息
@Service
public class AdvServiceImpl implements AdvService{

    @Resource
    AdvMapper advMapper;

    @Override
    public Adv findById(Long id) {
        return advMapper.findById(id);
    }

    @Override
    public List<Adv> findAll(Adv adv) {
        return advMapper.findAll(adv);
    }

    @Override
    public int insertAdvInfo(Adv adv) {
        return advMapper.insertAdvInfo(adv);
    }

    @Override
    public int updateAdvInfo(Adv adv) {
        return advMapper.updateAdvInfo(adv);
    }

    @Override
    public int deleteById(Long id) {
        return advMapper.deleteById(id);
    }
}
