package com.wx.wlcx.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.wlcx.mapper.CMMatcherMapper;
import com.wx.wlcx.mapper.MatcherMapper;
import com.wx.wlcx.po.CMMatcher;
import com.wx.wlcx.service.MatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatcherServiceImpl implements MatcherService {
    @Autowired
    private MatcherMapper matcherMapper;
    @Autowired
    private CMMatcherMapper cmMatcherMapper;

    @Override
    public List<CMMatcher> getAll() {
        return matcherMapper.getAll();
    }

    @Override
    public List<com.wx.wlcx.model.CMMatcher> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return cmMatcherMapper.getAll();
    }
}
