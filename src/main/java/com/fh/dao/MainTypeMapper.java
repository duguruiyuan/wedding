package com.fh.dao;

import com.fh.entity.MainType;

public interface MainTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MainType record);

    int insertSelective(MainType record);

    MainType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MainType record);

    int updateByPrimaryKey(MainType record);
}