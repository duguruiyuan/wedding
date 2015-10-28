package com.fh.dao;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.Favorites;

public interface FavoritesMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Favorites record);

	int insertSelective(Favorites record);

	Favorites selectByPrimaryKey(Long id);

	Favorites selectByUserIdAndP(@Param("userId") Long userId,
			@Param("productId") Long productId);

	Favorites selectByUserIdAndM(@Param("userId") Long userId,
			@Param("manId") Long manId);

	int updateByPrimaryKeySelective(Favorites record);

	int updateByPrimaryKey(Favorites record);
}