package com.wx.wlcx.mapper;

import com.wx.wlcx.model.CMMatcher;

import java.util.List;

public interface CMMatcherMapper {
    int insert(CMMatcher record);

    int insertSelective(CMMatcher record);

    List<CMMatcher> getAll();
}