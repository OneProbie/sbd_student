package com.qf.service;

import com.qf.entity.StuEntity;

import java.util.List;

public interface IStuService {

    List<StuEntity> stulist();

    StuEntity queryById(Integer sid);

    int updateById(StuEntity student);

    int deleById(Integer sid);

    int addStudent(StuEntity stuEntity);
}
