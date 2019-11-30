package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.ClassEntity;
import com.qf.entity.StuEntity;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Reference
    private IClassService classService;

    @Override
    public List<StuEntity> stulist() {

        List<StuEntity> stulist = stuMapper.selectList(null);

        for (StuEntity stu : stulist){

            Integer cid = stu.getCid();
            ClassEntity cla = classService.queryById(cid);

            stu.setCla(cla);
        }

        return stulist;
    }
}
