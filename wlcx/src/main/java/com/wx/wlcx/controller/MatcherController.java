package com.wx.wlcx.controller;

import com.wx.wlcx.po.CMMatcher;
import com.wx.wlcx.service.MatcherService;
import com.wx.wlcx.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
