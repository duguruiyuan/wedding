package com.fh.dao;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.Grade;

public interface GradeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Grade record);

	int insertSelective(Grade record);

	Grade selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Grade record);

	int updateByPrimaryKey(Grade record);

	Grade selectByUserIdAndProductIdAndOrderId(@Param("userId") Long userId,
			@Param("productId") Long productId, @Param("orderId") Long orderId);

}