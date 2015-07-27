package com.fh.dao;

import com.fh.entity.BusinessMan;

public interface BusinessManMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(BusinessMan record);

    int insertSelective(BusinessMan record);

    BusinessMan selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(BusinessMan record);

    int updateByPrimaryKey(BusinessMan record);
}