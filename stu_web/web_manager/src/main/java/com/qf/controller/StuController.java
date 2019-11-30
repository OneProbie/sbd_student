package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.StuEntity;
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

    @RequestMapping("stulist")
    public String StudentList(Model model){

        List<StuEntity> stulist = iStuService.stulist();
        model.addAttribute("stulist",stulist);

        return "stulist";
    }
}
