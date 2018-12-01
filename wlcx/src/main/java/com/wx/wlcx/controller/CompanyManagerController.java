package com.wx.wlcx.controller;

import com.wx.wlcx.model.CMCompany;
import com.wx.wlcx.resource.CompaniesListResource;
import com.wx.wlcx.resource.CompanyResource;
import com.wx.wlcx.service.CompanyService;
import com.wx.wlcx.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
public class CompanyManagerController {
    private final static Logger logger = LoggerFactory.getLogger(CompanyManagerController.class);
    @Autowired
    private CompanyService companyService;

    @GetMapping("/search/{pageNum}/{pageSize}/company")
    public ResponseEntity<JsonResult> findCompany(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                  @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                                  @RequestParam(value = "arCode", required = false) String arCode,
                                                  @RequestParam(value = "arName", required = false)  String arName){
    logger.info(String.format("get one page company, pageSize: %d, page: %d", pageNum, pageSize));
        JsonResult r = new JsonResult();
        try {
            verifyParames(keyword, arCode, arName);
            List<CMCompany> cmCompanies = companyService.findCompany(pageNum, pageSize, keyword, arCode, arName);
            r.setResult(new CompaniesListResource(cmCompanies));
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    private void verifyParames(String keyword, String arCode, String arName) throws Exception {
        if (StringUtils.isEmpty(keyword) && StringUtils.isEmpty(arCode) && StringUtils.isEmpty(arName)) {
            logger.error("keyword, arCode and arName is all null!!!");
            throw new Exception("params error!!");
        }
    }

    @GetMapping("/company/detail")
    public ResponseEntity<JsonResult> findCompanyDetail(@RequestParam(value = "coid") String coid){
        logger.info("findCompanyDetail");
        JsonResult r = new JsonResult();
        try {
            CMCompany cmCompany = companyService.findCompany(coid);
            r.setResult(new CompanyResource(cmCompany));
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
