package com.wx.wlcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//public class IndexController {
//
//    @RequestMapping("/test")
//    public String index() {
//        System.out.println("/index");
//        return "index";
//    }
//}

@RestController
public class IndexController {

    @GetMapping("/test")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}