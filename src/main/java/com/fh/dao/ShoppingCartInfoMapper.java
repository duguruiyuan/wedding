package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.MybatisPageable;
import com.fh.entity.ShoppingCartInfo;

public interface ShoppingCartInfoMapper {

	List<ShoppingCartInfo> findShoppingCartInfos(
			@Param(value = "appuserId") Long appuserId,
			@Param(value = "pageable") MybatisPageable pageable);

}
