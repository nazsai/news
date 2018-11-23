package com.minshang.eps.dao;

import com.minshang.eps.entity.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer orgid);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer orgid);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}