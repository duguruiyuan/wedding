package com.fh.dao;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.ShoppingCart;

public interface ShoppingCartMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ShoppingCart record);

	int insertSelective(ShoppingCart record);

	ShoppingCart selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ShoppingCart record);

	int updateByPrimaryKey(ShoppingCart record);

	ShoppingCart selectByProductId(@Param("productId") Long productId,
			@Param("userId") Long userId);
}