package com.fh.dao;

import com.fh.entity.ManImage;

public interface ManImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManImage record);

    int insertSelective(ManImage record);

    ManImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManImage record);

    int updateByPrimaryKey(ManImage record);
}