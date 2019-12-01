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

    //查询一个学生
    @Override
    public StuEntity queryById(Integer sid) {
        StuEntity student = stuMapper.selectById(sid);
        ClassEntity classes = classService.queryById(student.getCid());
        student.setCla(classes);
        return student;
    }

    //修改学生信息
    @Override
    public int updateById(StuEntity student) {
        int i = stuMapper.updateById(student);
        return i;
    }

    @Override
    public int deleById(Integer sid) {
        int i = stuMapper.deleteById(sid);
        return i;
    }

    @Override
    public int addStudent(StuEntity stuEntity) {
        int insert = stuMapper.insert(stuEntity);
        return insert;

    }


}
