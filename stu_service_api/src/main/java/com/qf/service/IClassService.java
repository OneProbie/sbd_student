package com.qf.service;

import com.qf.entity.ClassEntity;

import java.util.List;

public interface IClassService {

    List<ClassEntity> clsList();

    ClassEntity queryById(Integer id);

}
