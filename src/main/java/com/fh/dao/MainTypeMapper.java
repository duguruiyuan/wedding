package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.MainType;

public interface MainTypeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(MainType record);

	int insertSelective(MainType record);

	MainType selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MainType record);

	int updateByPrimaryKey(MainType record);

	List<MainType> findByIdAndLevel(@Param(value = "id") Long id,
			@Param(value = "level") String level);
}