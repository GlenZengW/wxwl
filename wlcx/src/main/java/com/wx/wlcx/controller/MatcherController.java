package com.wx.wlcx.controller;

import com.wx.wlcx.po.CMMatcher;
import com.wx.wlcx.service.MatcherService;
import com.wx.wlcx.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MatcherController {
    @Autowired
    private MatcherService matcherService;

    @GetMapping("/getAll")
    public ResponseEntity<JsonResult> getUserList (){
        JsonResult r = new JsonResult();
        try {
            List<CMMatcher> users = matcherService.getAll();
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @GetMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<JsonResult> findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        JsonResult r = new JsonResult();
        try {
            List<com.wx.wlcx.model.CMMatcher> users = matcherService.findAll(pageNum, pageSize);
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
