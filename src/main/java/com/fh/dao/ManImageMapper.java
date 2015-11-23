package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.ManImage;

public interface ManImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManImage record);

    int insertSelective(ManImage record);

    ManImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ManImage record);

    int updateByPrimaryKey(ManImage record);
    
    List<ManImage> findByUserId(@Param(value = "userId")Long userId);
}