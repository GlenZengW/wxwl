package com.wx.wlcx.mapper;

import com.wx.wlcx.model.CMCompany;

public interface CMCompanyMapper {
    int deleteByPrimaryKey(String coid);

    int insert(CMCompany record);

    int insertSelective(CMCompany record);

    CMCompany selectByPrimaryKey(String coid);

    int updateByPrimaryKeySelective(CMCompany record);

    int updateByPrimaryKey(CMCompany record);
}