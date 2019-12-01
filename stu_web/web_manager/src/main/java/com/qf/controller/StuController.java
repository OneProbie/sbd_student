package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.ClassEntity;
import com.qf.entity.StuEntity;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StuController {

    @Reference
    private IStuService iStuService;

    @Reference
    private IClassService classService;


    @RequestMapping("stulist")
    public String StudentList(Model model){

        List<StuEntity> stulist = iStuService.stulist();
        model.addAttribute("stulist",stulist);

        return "stulist";
    }

    //查询一个学生
    @RequestMapping("/queryById")
    public String queryById(Integer sid,Model model){
        StuEntity student = iStuService.queryById(sid);
        List<ClassEntity> classes = classService.clsList();
        model.addAttribute("classes",classes);
        model.addAttribute("student",student);
        return "update";
    }

    //修改学生的信息
    @RequestMapping("/updateById")
    public String updateById(StuEntity student){
        int i = iStuService.updateById(student);
        if(i>0){
            return "redirect:/student/stulist";
        }else {
            return "update";
        }
    }

    //删除学生
    @RequestMapping("/deleById")
    public String deleById(Integer sid,Integer cid){
        int i1=iStuService.deleById(sid);
        int i=classService.updateClassNum(cid);
        if(i1>0 && i>0){
            return "redirect:/student/stulist";
        }else {
            return null;
        }

    }

    //页面跳转
    @RequestMapping("/jumpAdd")
    public String jumpAdd(Model model){
        List<ClassEntity> classes = classService.clsList();
        model.addAttribute("classes",classes);
        return "addStu";
    }

    //添加学生
    @RequestMapping("/addStudent")
    public String addStudent(StuEntity stuEntity){
        int i1=iStuService.addStudent(stuEntity);
        //数量减一
        int i=classService.updateClassNumJianYi(stuEntity.getCid());
        if(i1>0 && i>0){
            return "redirect:/student/stulist";
        }else {
            return null;
        }

    }

}
