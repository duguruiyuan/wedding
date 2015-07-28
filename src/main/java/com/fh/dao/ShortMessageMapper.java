package com.fh.dao;

import com.fh.entity.ShortMessage;

public interface ShortMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShortMessage record);

    int insertSelective(ShortMessage record);

    ShortMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShortMessage record);

    int updateByPrimaryKeyWithBLOBs(ShortMessage record);

    int updateByPrimaryKey(ShortMessage record);
}