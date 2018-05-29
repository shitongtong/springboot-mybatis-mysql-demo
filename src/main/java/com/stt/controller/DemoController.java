package com.stt.controller;

import com.stt.po.Demo;
import com.stt.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shitt7 on 2018/5/25.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<Demo> demoList = demoService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("demoList",demoList);
        modelAndView.setViewName("demo");
        return modelAndView;
    }

}
