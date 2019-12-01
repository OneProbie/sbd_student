package com.qf.service;

import com.qf.entity.ClassEntity;

import java.util.List;

public interface IClassService {

    List<ClassEntity> clsList();

    /**
     * 按ID查询班级信息
     * @param id
     * @return
     */
    ClassEntity queryById(Integer id);

    /**
     * 添加一条班级信息
     * @param cla
     * @return
     */
    int insClass(ClassEntity cla);

    /**
     * 根据Id删除一条班级信息
     * @param cid
     * @return
     */
    int delClass(Integer cid);

    /**
     * 根据Id修改班级信息
     * @param cla
     * @return
     */
    int updClass(ClassEntity cla);

    int updateClassNum(Integer cid);

    int updateClassNumJianYi(Integer cid);
}
