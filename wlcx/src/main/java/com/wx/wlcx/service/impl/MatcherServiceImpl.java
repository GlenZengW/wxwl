package com.wx.wlcx.service.impl;

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

    @Override
    public List<CMMatcher> getAll() {
        return matcherMapper.getAll();
    }
}
