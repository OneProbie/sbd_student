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

    /**
     * 查询所有的班级信息
     * @param model
     * @return
     */
    @RequestMapping("clslist")
    public String stuClasses(Model model){

        List<ClassEntity> clslist = classService.clsList();
        model.addAttribute("clslist",clslist);
        return "clslist";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("addskip")
    public String addSkip(){


        return "addskip";
    }

    /**
     * 添加班级
     * @param cla
     * @return
     */
    @RequestMapping("addcls")
    public String addClass(ClassEntity cla){

        int reply = classService.insClass(cla);

        return "redirect:/classes/clslist";
    }

    /**
     * 根据Id删除
     * @param cid
     * @return
     */
    @RequestMapping("delcla")
    public String delClass(Integer cid){

       int reply = classService.delClass(cid);

        return "redirect:/classes/clslist";
    }

    /**
     * 根据Id查询班级信息修改回填
     * @param cid
     * @return
     */
    @RequestMapping("updskip")
    public String updSkip(Integer cid,Model model){

        ClassEntity cla = classService.queryById(cid);
        model.addAttribute("cla",cla);

        return "updcla";
    }

    @RequestMapping("updcla")
    public String updClass(ClassEntity cla){

        int reply = classService.updClass(cla);
        return "redirect:/classes/clslist";
    }
}
