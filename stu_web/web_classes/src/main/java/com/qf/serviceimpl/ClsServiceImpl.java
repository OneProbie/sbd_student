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

    /**
     * 查询所有的班级
     * @return
     */
    @Override
    public List<ClassEntity> clsList() {

        //条件查询
        /*QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cname","一年一班");*/

        return clsMapper.selectList(null);
    }

    /**
     * 按Id查询班级信息
     * @param id
     * @return
     */
    @Override
    public ClassEntity queryById(Integer id) {

        return clsMapper.selectById(id);
    }

    @Override
    public int updateClassNum(Integer cid) {
        ClassEntity classEntity = clsMapper.selectById(cid);
        Integer cnum = classEntity.getCnum();
        cnum=cnum-1;
        classEntity.setCnum(cnum);
        int i = clsMapper.updateById(classEntity);
        return i;
    }

    @Override
    public int updateClassNumJianYi(Integer cid) {
        ClassEntity classEntity = clsMapper.selectById(cid);
        Integer cnum = classEntity.getCnum();
        cnum=cnum+1;
        classEntity.setCnum(cnum);
        int i = clsMapper.updateById(classEntity);
        return i;
    }

    /**
     * 添加一条班级信息
     * @param cla
     * @return
     */
    @Override
    public int insClass(ClassEntity cla) {

        return clsMapper.insert(cla);
    }

    /**
     * 根据Id删除一条班级信息
     * @param cid
     * @return
     */
    @Override
    public int delClass(Integer cid) {

        return clsMapper.deleteById(cid);
    }

    /**
     * 根据Id修改班级信息
     * @param cla
     * @return
     */
    @Override
    public int updClass(ClassEntity cla) {

        return clsMapper.updateById(cla);
    }
}
