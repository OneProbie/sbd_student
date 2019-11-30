package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.ClassEntity;
import com.qf.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClsController {

    @Reference
    private IClassService classService;

    @RequestMapping("clslist")
    public String stuClasses(Model model){

        List<ClassEntity> clslist = classService.clsList();
        model.addAttribute("clslist",clslist);
        return "clslist";
    }

}
