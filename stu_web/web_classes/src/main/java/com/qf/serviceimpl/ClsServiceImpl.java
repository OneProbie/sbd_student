package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClsMapper;
import com.qf.entity.ClassEntity;
import com.qf.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClsServiceImpl implements IClassService {

    @Autowired
    private ClsMapper clsMapper;

    @Override
    public List<ClassEntity> clsList() {

        //条件查询
        /*QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cname","一年一班");*/

        return clsMapper.selectList(null);
    }

    @Override
    public ClassEntity queryById(Integer id) {

        return clsMapper.selectById(id);
    }
}
